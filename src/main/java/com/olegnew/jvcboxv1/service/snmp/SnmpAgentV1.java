package com.olegnew.jvcboxv1.service.snmp;

import com.olegnew.jvcboxv1.model.cbox.Element;
import com.olegnew.jvcboxv1.model.cbox.FullInformation;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import lombok.Data;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
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
                                             String community) {
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
                String valluev = event.getResponse()
                        .get(0)
                        .getVariable()
                        .toString();
                hashMapResult.put(current.getName(), valluev);
                pdu.clear();
            } else {
                break;
            }
        }
        closeConnection();
        return hashMapResult;
    }

    public boolean setOptionsByName(String address,
                                     String community,
                                     String name,
                                     String value) {

        openConnection(address,community);
        closeConnection();
        return true;
    }

    public FullInformation setFullInformationOnTheDevice(FullInformation fullInformation,
                                                         List<Element> elementList) {
        openConnection(fullInformation.getReceivedInformation().get("SysIPaddress"),
                fullInformation.getReceivedInformation().get("SysSnmpRdComm"));
        PDU pdu = new PDU();
        pdu.setType(PDU.SET);
        ResponseEvent event = null;

        return fullInformation;
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

    private boolean checkConnection(String address) {
        return true;
    }

}
