package com.olegnew.jvcboxv1.service.snmp;

import com.olegnew.jvcboxv1.model.cbox.Element;
import com.olegnew.jvcboxv1.model.cbox.FullInformation;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Data;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.stereotype.Service;

@Service
@Data
public class SnmpAgentV1 {
    private static final int SNMP_RETRIES = 3;
    private static final int SNMP_PORT = 161;
    private static final long SNMP_TIMEOUT = 1000L;
    private Snmp snmp = null;
    private TransportMapping transport = null;

    public HashMap<String, String> getTarget(String address,
                                             List<Element> elementList,
                                             String community, boolean hasOperatorRole) {
        HashMap<String, String> hashMapResult = new HashMap<>();
        CommunityTarget target = openConnection(address, community);
        PDU pdu = new PDU();
        pdu.setType(PDU.GET);
        ResponseEvent event = null;

        for (Element current: elementList) {
            pdu.add(new VariableBinding(new OID(current.getOid())));
            try {
                event = snmp.send(pdu, target, null);
            } catch (IOException e) {
                throw new RuntimeException("Can't create event", e);
            }
            if (event != null && event.getPeerAddress() != null) {
                String responseValue = event.getResponse()
                        .get(0)
                        .getVariable()
                        .toString();
                if (!hasOperatorRole && current.getName().contains("Comm")) {
                    continue;
                }
                hashMapResult.put(current.getName(), responseValue);
                pdu.clear();
            } else {
                break;
            }
        }
        closeConnection();
        return hashMapResult;
    }

    public void setFullInformationOnTheDevice(FullInformation fullInformation,
                                                         List<Element> elementList) {
        CommunityTarget target = openConnection(fullInformation
                        .getReceivedInformation().get("SysIPaddress"),
                fullInformation.getReceivedInformation().get("SysSnmpRdComm"));
        HashMap<String, String> receivedInformation = fullInformation.getReceivedInformation();
        receivedInformation.forEach((k, v) -> {
            Element currentElement = elementList.stream()
                    .filter(e -> e.getName().equals(k))
                    .findFirst()
                    .get();
            String oid = currentElement.getOid();
            VariableBinding variableBinding = new VariableBinding(new OID(oid));
            OctetString s = OctetString.fromHexString("48:57:54:43:d0:bf:30:04");
            String currentKey = fullInformation.getReceivedInformation().get(k);
            if (currentElement.getDataType().equals("Integer")) {
                variableBinding.setVariable(new Integer32(Integer.parseInt(currentKey)));
            } else if (isItAnAddress(currentKey)) {
                variableBinding.setVariable(new IpAddress(currentKey));
            } else {
                variableBinding.setVariable(new OctetString(currentKey));
            }
            PDU pdu = new PDU();
            pdu.setType(PDU.SET);
            pdu.add(variableBinding);
            try {
                ResponseEvent event = snmp.send(pdu, target);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        closeConnection();
    }

    private CommunityTarget openConnection(String address, String community) {
        CommunityTarget target = new CommunityTarget();
        UdpAddress targetAddress = new UdpAddress();
        try {
            targetAddress.setInetAddress(InetAddress.getByName(address));
        } catch (UnknownHostException e) {
            throw new RuntimeException("The string" + address + "is not an IP address ", e);
        }
        targetAddress.setPort(SNMP_PORT);
        target.setAddress(targetAddress);
        target.setCommunity(new OctetString(community));
        target.setVersion(SnmpConstants.version1);
        try {
            transport = new DefaultUdpTransportMapping();
            snmp = new Snmp(transport);
            transport.listen();
        } catch (IOException e) {
            throw new RuntimeException("Can't create transport", e);
        }
        return target;
    }

    private void closeConnection() {
        try {
            try {
                if (transport != null) {
                    transport.close();
                    transport = null;
                }
            } finally {
                if (snmp != null) {
                    snmp.close();
                    snmp = null;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't close transport", e);
        }
    }

    private boolean isItAnAddress(String address) {
        String regex = "^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$";
        Pattern p = Pattern.compile(regex);

        if (address == null) {
            return false;
        }
        Matcher m = p.matcher(address);
        return m.matches();
    }

    public void rebootCbox(String ipAddress, String community) {
        CommunityTarget communityTarget = openConnection(ipAddress, community);
        String oid = "1.3.6.1.4.1.17484.2.1.11.0";
        VariableBinding variableBinding = new VariableBinding(new OID(oid));
        variableBinding.setVariable(OctetString.fromHexString("0F"));
        PDU pdu = new PDU();
        pdu.setType(PDU.SET);
        pdu.add(variableBinding);
        try {
            ResponseEvent event = snmp.send(pdu, communityTarget);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }

}
