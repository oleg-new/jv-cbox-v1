package com.olegnew.jvcboxv1.service.cbox;

import com.olegnew.jvcboxv1.model.cbox.Cbox;
import com.olegnew.jvcboxv1.model.cbox.Element;
import java.util.ArrayList;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class DefaultDevice {

    private void addNewElement(Cbox cbox,Element element) {
        cbox.getElementList().add(element);
    }

    public Cbox createDefaultCbox(Cbox cbox) {
        cbox.setElementList(new ArrayList<>());

        Element element = new Element();
        element.setOid("1.3.6.1.4.1.17484.2.1.1.0");
        element.setName("SystemName");
        element.setUsability(false);
        element.setRewritable(false);
        addNewElement(cbox, element);

        Element element1 = new Element();
        element1.setOid("1.3.6.1.2.1.2.2.1.2.1");
        element1.setName("ifDescr");
        element1.setUsability(false);
        element1.setRewritable(false);
        addNewElement(cbox, element1);

        Element element2 = new Element();
        element2.setOid("1.3.6.1.2.1.2.2.1.6.1");
        element2.setName("ifPhysAddress");
        element2.setUsability(true);
        element2.setRewritable(false);
        addNewElement(cbox, element2);

        Element element3 = new Element();
        element3.setOid("1.3.6.1.2.1.2.2.1.9.1");
        element3.setName("ifLastChange");
        element3.setUsability(true);
        element3.setRewritable(true);
        addNewElement(cbox, element3);

        Element element4 = new Element();
        element4.setOid("1.3.6.1.4.1.17484.2.1.2.0");
        element4.setName("SysMACaddress");
        element4.setUsability(true);
        element4.setRewritable(true);
        addNewElement(cbox, element4);

        Element element5 = new Element();
        element5.setOid("1.3.6.1.4.1.17484.2.1.3.0");
        element5.setName("SysIPaddress");
        element5.setUsability(true);
        element5.setRewritable(true);
        addNewElement(cbox, element5);

        Element element6 = new Element();
        element6.setOid("1.3.6.1.4.1.17484.2.1.4.0");
        element6.setName("SysIPmask");
        element6.setUsability(true);
        element6.setRewritable(true);
        addNewElement(cbox, element6);

        Element element7 = new Element();
        element7.setOid("1.3.6.1.4.1.17484.2.1.5.0");
        element7.setName("SysGateIPaddress");
        element7.setUsability(true);
        element7.setRewritable(true);
        addNewElement(cbox, element7);

        Element element8 = new Element();
        element8.setOid("1.3.6.1.4.1.17484.2.1.6.0");
        element8.setName("SysTrapIPaddress");
        element8.setUsability(true);
        element8.setRewritable(true);
        addNewElement(cbox, element8);

        Element element9 = new Element();
        element9.setOid("1.3.6.1.4.1.17484.2.1.7.0");
        element9.setName("SysSnmpAccess");
        element9.setUsability(true);
        element9.setRewritable(true);
        addNewElement(cbox, element9);

        Element element10 = new Element();
        element10.setOid("1.3.6.1.4.1.17484.2.1.8.0");
        element10.setName("SysSnmpRdComm");
        element10.setUsability(true);
        element10.setRewritable(true);
        addNewElement(cbox, element10);

        Element element11 = new Element();
        element11.setOid("1.3.6.1.4.1.17484.2.1.9.0");
        element11.setName("SysSnmpWrComm");
        element11.setUsability(true);
        element11.setRewritable(true);
        addNewElement(cbox, element11);

        Element element12 = new Element();
        element12.setOid("1.3.6.1.4.1.17484.2.1.10.0");
        element12.setName("SysSnmpTrapComm");
        element12.setUsability(true);
        element12.setRewritable(true);
        addNewElement(cbox, element12);

        Element element13 = new Element();
        element13.setOid("1.3.6.1.4.1.17484.2.1.11.0");
        element13.setName("Restart");
        element13.setUsability(true);
        element13.setRewritable(true);
        addNewElement(cbox, element13);

        Element element21 = new Element();
        element21.setOid("1.3.6.1.4.1.17484.2.2.2.1.1.1");
        element21.setName("PinC1");
        element21.setUsability(true);
        element21.setRewritable(true);
        addNewElement(cbox, element21);

        Element element22 = new Element();
        element22.setOid("1.3.6.1.4.1.17484.2.2.2.1.1.2");
        element22.setName("PinC2");
        element22.setUsability(true);
        element22.setRewritable(true);
        addNewElement(cbox, element22);

        Element element23 = new Element();
        element23.setOid("1.3.6.1.4.1.17484.2.2.2.1.1.3");
        element23.setName("PinC3");
        element23.setUsability(true);
        element23.setRewritable(true);
        addNewElement(cbox, element23);

        Element element24 = new Element();
        element24.setOid("1.3.6.1.4.1.17484.2.2.2.1.1.4");
        element24.setName("PinC4");
        element24.setUsability(true);
        element24.setRewritable(true);
        addNewElement(cbox, element24);

        Element element25 = new Element();
        element25.setOid("1.3.6.1.4.1.17484.2.2.2.1.1.5");
        element25.setName("PinC5");
        element25.setUsability(true);
        element25.setRewritable(true);
        addNewElement(cbox, element25);

        Element element26 = new Element();
        element26.setOid("1.3.6.1.4.1.17484.2.2.2.1.1.6");
        element26.setName("PinC6");
        element26.setUsability(true);
        element26.setRewritable(true);
        addNewElement(cbox, element26);

        Element element27 = new Element();
        element27.setOid("1.3.6.1.4.1.17484.2.2.2.1.1.7");
        element27.setName("PinC7");
        element27.setUsability(true);
        element27.setRewritable(true);
        addNewElement(cbox, element27);

        Element element28 = new Element();
        element28.setOid("1.3.6.1.4.1.17484.2.2.2.1.1.8");
        element28.setName("PinC8");
        element28.setUsability(true);
        element28.setRewritable(true);
        addNewElement(cbox, element28);

        Element element31 = new Element();
        element31.setOid("1.3.6.1.4.1.17484.2.2.2.1.2.1");
        element31.setName("DDRC1");
        element31.setUsability(true);
        element31.setRewritable(true);
        addNewElement(cbox, element31);

        Element element32 = new Element();
        element32.setOid("1.3.6.1.4.1.17484.2.2.2.1.2.2");
        element32.setName("DDRC2");
        element32.setUsability(true);
        element32.setRewritable(true);
        addNewElement(cbox, element32);

        Element element33 = new Element();
        element33.setOid("1.3.6.1.4.1.17484.2.2.2.1.2.3");
        element33.setName("DDRC3");
        element33.setUsability(true);
        element33.setRewritable(true);
        addNewElement(cbox, element33);

        Element element34 = new Element();
        element34.setOid("1.3.6.1.4.1.17484.2.2.2.1.2.4");
        element34.setName("DDRC4");
        element34.setUsability(true);
        element34.setRewritable(true);
        addNewElement(cbox, element34);

        Element element35 = new Element();
        element35.setOid("1.3.6.1.4.1.17484.2.2.2.1.2.5");
        element35.setName("DDRC5");
        element35.setUsability(true);
        element35.setRewritable(true);
        addNewElement(cbox, element35);

        Element element36 = new Element();
        element36.setOid("1.3.6.1.4.1.17484.2.2.2.1.2.6");
        element36.setName("DDRC6");
        element36.setUsability(true);
        element36.setRewritable(true);
        addNewElement(cbox, element36);

        Element element37 = new Element();
        element37.setOid("1.3.6.1.4.1.17484.2.2.2.1.2.7");
        element37.setName("DDRC7");
        element37.setUsability(true);
        element37.setRewritable(true);
        addNewElement(cbox, element37);

        Element element38 = new Element();
        element38.setOid("1.3.6.1.4.1.17484.2.2.2.1.2.8");
        element38.setName("DDRC8");
        element38.setUsability(true);
        element38.setRewritable(true);
        addNewElement(cbox, element38);

        Element element41 = new Element();
        element41.setOid("1.3.6.1.4.1.17484.2.2.2.1.3.1");
        element41.setName("PortC1");
        element41.setUsability(true);
        element41.setRewritable(true);
        addNewElement(cbox, element41);

        Element element42 = new Element();
        element42.setOid("1.3.6.1.4.1.17484.2.2.2.1.3.2");
        element42.setName("PortC2");
        element42.setUsability(true);
        element42.setRewritable(true);
        addNewElement(cbox, element42);

        Element element43 = new Element();
        element43.setOid("1.3.6.1.4.1.17484.2.2.2.1.3.3");
        element43.setName("PortC3");
        element43.setUsability(true);
        element43.setRewritable(true);
        addNewElement(cbox, element43);

        Element element44 = new Element();
        element44.setOid("1.3.6.1.4.1.17484.2.2.2.1.3.4");
        element44.setName("PortC4");
        element44.setUsability(true);
        element44.setRewritable(true);
        addNewElement(cbox, element44);

        Element element45 = new Element();
        element45.setOid("1.3.6.1.4.1.17484.2.2.2.1.3.5");
        element45.setName("PortC5");
        element45.setUsability(true);
        element45.setRewritable(true);
        addNewElement(cbox, element45);

        Element element46 = new Element();
        element46.setOid("1.3.6.1.4.1.17484.2.2.2.1.3.6");
        element46.setName("PortC6");
        element46.setUsability(true);
        element46.setRewritable(true);
        addNewElement(cbox, element46);

        Element element47 = new Element();
        element47.setOid("1.3.6.1.4.1.17484.2.2.2.1.3.7");
        element47.setName("PortC7");
        element47.setUsability(true);
        element47.setRewritable(true);
        addNewElement(cbox, element47);

        Element element48 = new Element();
        element48.setOid("1.3.6.1.4.1.17484.2.2.2.1.3.8");
        element48.setName("PortC8");
        element48.setUsability(true);
        element48.setRewritable(true);
        addNewElement(cbox, element48);

        Element element51 = new Element();
        element51.setOid("1.3.6.1.4.1.17484.2.2.2.1.4.1");
        element51.setName("PinE1");
        element51.setUsability(true);
        element51.setRewritable(true);
        addNewElement(cbox, element51);

        Element element52 = new Element();
        element52.setOid("1.3.6.1.4.1.17484.2.2.2.1.4.2");
        element52.setName("PinE2");
        element52.setUsability(true);
        element52.setRewritable(true);
        addNewElement(cbox, element52);

        Element element53 = new Element();
        element53.setOid("1.3.6.1.4.1.17484.2.2.2.1.4.3");
        element53.setName("PinE3");
        element53.setUsability(true);
        element53.setRewritable(true);
        addNewElement(cbox, element53);

        Element element54 = new Element();
        element54.setOid("1.3.6.1.4.1.17484.2.2.2.1.4.4");
        element54.setName("PinE4");
        element54.setUsability(true);
        element54.setRewritable(true);
        addNewElement(cbox, element54);

        Element element55 = new Element();
        element55.setOid("1.3.6.1.4.1.17484.2.2.2.1.4.5");
        element55.setName("PinE5");
        element55.setUsability(true);
        element55.setRewritable(true);
        addNewElement(cbox, element55);

        Element element56 = new Element();
        element56.setOid("1.3.6.1.4.1.17484.2.2.2.1.4.6");
        element56.setName("PinE6");
        element56.setUsability(true);
        element56.setRewritable(true);
        addNewElement(cbox, element56);

        Element element57 = new Element();
        element57.setOid("1.3.6.1.4.1.17484.2.2.2.1.4.7");
        element57.setName("PinE7");
        element57.setUsability(true);
        element57.setRewritable(true);
        addNewElement(cbox, element57);

        Element element58 = new Element();
        element58.setOid("1.3.6.1.4.1.17484.2.2.2.1.4.8");
        element58.setName("PinE8");
        element58.setUsability(true);
        element58.setRewritable(true);
        addNewElement(cbox, element58);

        Element element61 = new Element();
        element61.setOid("1.3.6.1.4.1.17484.2.2.2.1.5.1");
        element61.setName("DDRE1");
        element61.setUsability(true);
        element61.setRewritable(true);
        addNewElement(cbox, element61);

        Element element62 = new Element();
        element62.setOid("1.3.6.1.4.1.17484.2.2.2.1.5.2");
        element62.setName("DDRE2");
        element62.setUsability(true);
        element62.setRewritable(true);
        addNewElement(cbox, element62);

        Element element63 = new Element();
        element63.setOid("1.3.6.1.4.1.17484.2.2.2.1.5.3");
        element63.setName("DDRE3");
        element63.setUsability(true);
        element63.setRewritable(true);
        addNewElement(cbox, element63);

        Element element64 = new Element();
        element64.setOid("1.3.6.1.4.1.17484.2.2.2.1.5.4");
        element64.setName("DDRE4");
        element64.setUsability(true);
        element64.setRewritable(true);
        addNewElement(cbox, element64);

        Element element65 = new Element();
        element65.setOid("1.3.6.1.4.1.17484.2.2.2.1.5.5");
        element65.setName("DDRE5");
        element65.setUsability(true);
        element65.setRewritable(true);
        addNewElement(cbox, element65);

        Element element66 = new Element();
        element66.setOid("1.3.6.1.4.1.17484.2.2.2.1.5.6");
        element66.setName("DDRE6");
        element66.setUsability(true);
        element66.setRewritable(true);
        addNewElement(cbox, element66);

        Element element67 = new Element();
        element67.setOid("1.3.6.1.4.1.17484.2.2.2.1.5.7");
        element67.setName("DDRE7");
        element67.setUsability(true);
        element67.setRewritable(true);
        addNewElement(cbox, element67);

        Element element68 = new Element();
        element68.setOid("1.3.6.1.4.1.17484.2.2.2.1.5.8");
        element68.setName("DDRE8");
        element68.setUsability(true);
        element68.setRewritable(true);
        addNewElement(cbox, element68);

        Element element71 = new Element();
        element71.setOid("1.3.6.1.4.1.17484.2.2.2.1.6.1");
        element71.setName("PortE1");
        element71.setUsability(true);
        element71.setRewritable(true);
        addNewElement(cbox, element71);

        Element element72 = new Element();
        element72.setOid("1.3.6.1.4.1.17484.2.2.2.1.6.2");
        element72.setName("PortE2");
        element72.setUsability(true);
        element72.setRewritable(true);
        addNewElement(cbox, element72);

        Element element73 = new Element();
        element73.setOid("1.3.6.1.4.1.17484.2.2.2.1.6.3");
        element73.setName("PortE3");
        element73.setUsability(true);
        element73.setRewritable(true);
        addNewElement(cbox, element73);

        Element element74 = new Element();
        element74.setOid("1.3.6.1.4.1.17484.2.2.2.1.6.4");
        element74.setName("PortE4");
        element74.setUsability(true);
        element74.setRewritable(true);
        addNewElement(cbox, element74);

        Element element75 = new Element();
        element75.setOid("1.3.6.1.4.1.17484.2.2.2.1.6.5");
        element75.setName("PortE5");
        element75.setUsability(true);
        element75.setRewritable(true);
        addNewElement(cbox, element75);

        Element element76 = new Element();
        element76.setOid("1.3.6.1.4.1.17484.2.2.2.1.6.6");
        element76.setName("PortE6");
        element76.setUsability(true);
        element76.setRewritable(true);
        addNewElement(cbox, element76);

        Element element77 = new Element();
        element77.setOid("1.3.6.1.4.1.17484.2.2.2.1.6.7");
        element77.setName("PortE7");
        element77.setUsability(true);
        element77.setRewritable(true);
        addNewElement(cbox, element77);

        Element element78 = new Element();
        element78.setOid("1.3.6.1.4.1.17484.2.2.2.1.6.8");
        element78.setName("PortE8");
        element78.setUsability(true);
        element78.setRewritable(true);
        addNewElement(cbox, element78);

        Element element80 = new Element();
        element80.setOid("1.3.6.1.4.1.17484.2.5.1.0");
        element80.setName("R-LED");
        element80.setUsability(true);
        element80.setRewritable(true);
        addNewElement(cbox, element80);

        Element element81 = new Element();
        element81.setOid("1.3.6.1.4.1.17484.2.5.2.0");
        element81.setName("G-LED");
        element81.setUsability(true);
        element81.setRewritable(true);
        addNewElement(cbox, element81);

        Element element82 = new Element();
        element82.setOid("1.3.6.1.4.1.17484.2.4.1.0");
        element82.setName("ACswitch0");
        element82.setUsability(true);
        element82.setRewritable(true);
        addNewElement(cbox, element82);

        Element element83 = new Element();
        element83.setOid("1.3.6.1.4.1.17484.2.4.2.0");
        element83.setName("DCswitch0");
        element83.setUsability(true);
        element83.setRewritable(true);
        addNewElement(cbox, element83);

        Element element84 = new Element();
        element84.setOid("1.3.6.1.4.1.17484.2.4.3.0");
        element84.setName("DCswitch1");
        element84.setUsability(true);
        element84.setRewritable(true);
        addNewElement(cbox, element84);

        Element element85 = new Element();
        element85.setOid("1.3.6.1.4.1.17484.2.4.4.0");
        element85.setName("DCswitch2");
        element85.setUsability(true);
        element85.setRewritable(true);
        addNewElement(cbox, element85);

        Element element86 = new Element();
        element86.setOid("1.3.6.1.4.1.17484.2.4.5.0");
        element86.setName("DCswitch3");
        element86.setUsability(true);
        element86.setRewritable(true);
        addNewElement(cbox, element86);

        Element element87 = new Element();
        element87.setOid("1.3.6.1.4.1.17484.2.3.1.0");
        element87.setName("AlarmIn0");
        element87.setUsability(true);
        element87.setRewritable(false);
        addNewElement(cbox, element87);

        Element element88 = new Element();
        element88.setOid("1.3.6.1.4.1.17484.2.3.2.0");
        element88.setName("AlarmIn1");
        element88.setUsability(true);
        element88.setRewritable(false);
        addNewElement(cbox, element88);

        Element element89 = new Element();
        element89.setOid("1.3.6.1.4.1.17484.2.3.3.0");
        element89.setName("AlarmIn2");
        element89.setUsability(true);
        element89.setRewritable(false);
        addNewElement(cbox, element89);

        Element element90 = new Element();
        element90.setOid("1.3.6.1.4.1.17484.2.3.4.0");
        element90.setName("AlarmIn3");
        element90.setUsability(true);
        element90.setRewritable(false);
        addNewElement(cbox, element90);

        Element element91 = new Element();
        element91.setOid("1.3.6.1.4.1.17484.2.3.5.0");
        element91.setName("AlarmIn4");
        element91.setUsability(true);
        element91.setRewritable(false);
        addNewElement(cbox, element91);

        Element element92 = new Element();
        element92.setOid("1.3.6.1.4.1.17484.2.3.6.0");
        element92.setName("AlarmOut0");
        element92.setUsability(true);
        element92.setRewritable(true);
        addNewElement(cbox, element92);

        Element element93 = new Element();
        element93.setOid("1.3.6.1.4.1.17484.2.3.7.0");
        element93.setName("AlarmOut1");
        element93.setUsability(true);
        element93.setRewritable(true);
        addNewElement(cbox, element93);

        Element element94 = new Element();
        element94.setOid("1.3.6.1.4.1.17484.2.3.8.0");
        element94.setName("AlarmOut2");
        element94.setUsability(true);
        element94.setRewritable(true);
        addNewElement(cbox, element94);

        Element element95 = new Element();
        element95.setOid("1.3.6.1.4.1.17484.2.3.9.0");
        element95.setName("AlarmTrapVar");
        element95.setUsability(true);
        element95.setRewritable(false);
        addNewElement(cbox, element95);

        Element element96 = new Element();
        element96.setOid("1.3.6.1.4.1.17484.2.3.10.0");
        element96.setName("AlarmStatusVar");
        element96.setUsability(true);
        element96.setRewritable(false);
        addNewElement(cbox, element96);

        Element element97 = new Element();
        element97.setOid("1.3.6.1.4.1.17484.2.3.11.0");
        element97.setName("AlarmSoftArmed");
        element97.setUsability(true);
        element97.setRewritable(true);
        addNewElement(cbox, element97);

        Element element98 = new Element();
        element98.setOid("1.3.6.1.4.1.17484.2.3.12.0");
        element98.setName("AlarmSoftDisArm");
        element98.setUsability(true);
        element98.setRewritable(true);
        addNewElement(cbox, element98);

        Element element99 = new Element();
        element99.setOid("1.3.6.1.4.1.17484.2.3.13.0");
        element99.setName("AlarmMaskZone1");
        element99.setUsability(true);
        element99.setRewritable(true);
        addNewElement(cbox, element99);

        Element element100 = new Element();
        element100.setOid("1.3.6.1.4.1.17484.2.3.14.0");
        element100.setName("AlarmMaskZone2");
        element100.setUsability(true);
        element100.setRewritable(true);
        addNewElement(cbox, element100);

        Element element101 = new Element();
        element101.setOid("1.3.6.1.4.1.17484.2.3.15.0");
        element101.setName("AlarmMaskZone3");
        element101.setUsability(true);
        element101.setRewritable(true);
        addNewElement(cbox, element101);

        Element element111 = new Element();
        element111.setOid("1.3.6.1.4.1.17484.2.6.2.1.1.1");
        element111.setName("Temperature Value1");
        element111.setUsability(true);
        element111.setRewritable(false);
        addNewElement(cbox, element111);

        Element element121 = new Element();
        element121.setOid("1.3.6.1.4.1.17484.2.6.2.1.2.1");
        element121.setName("ROM content1");
        element121.setUsability(true);
        element121.setRewritable(false);
        addNewElement(cbox, element121);

        Element element112 = new Element();
        element112.setOid("1.3.6.1.4.1.17484.2.6.2.1.1.2");
        element112.setName("Temperature Value2");
        element112.setUsability(true);
        element112.setRewritable(false);
        addNewElement(cbox, element112);

        Element element122 = new Element();
        element122.setOid("1.3.6.1.4.1.17484.2.6.2.1.2.2");
        element122.setName("ROM content2");
        element122.setUsability(true);
        element122.setRewritable(false);
        addNewElement(cbox, element122);

        Element element113 = new Element();
        element113.setOid("1.3.6.1.4.1.17484.2.6.2.1.1.3");
        element113.setName("Temperature Value3");
        element113.setUsability(true);
        element113.setRewritable(false);
        addNewElement(cbox, element113);

        Element element123 = new Element();
        element123.setOid("1.3.6.1.4.1.17484.2.6.2.1.2.3");
        element123.setName("ROM content3");
        element123.setUsability(true);
        element123.setRewritable(false);
        addNewElement(cbox, element123);

        Element element114 = new Element();
        element114.setOid("1.3.6.1.4.1.17484.2.6.2.1.1.4");
        element114.setName("Temperature Value4");
        element114.setUsability(true);
        element114.setRewritable(false);
        addNewElement(cbox, element114);

        Element element124 = new Element();
        element124.setOid("1.3.6.1.4.1.17484.2.6.2.1.2.4");
        element124.setName("ROM content4");
        element124.setUsability(true);
        element124.setRewritable(false);
        addNewElement(cbox, element124);

        Element element115 = new Element();
        element115.setOid("1.3.6.1.4.1.17484.2.6.2.1.1.5");
        element115.setName("Temperature Value5");
        element115.setUsability(true);
        element115.setRewritable(false);
        addNewElement(cbox, element115);

        Element element125 = new Element();
        element125.setOid("1.3.6.1.4.1.17484.2.6.2.1.2.5");
        element125.setName("ROM content5");
        element125.setUsability(true);
        element125.setRewritable(false);
        addNewElement(cbox, element125);

        Element element116 = new Element();
        element116.setOid("1.3.6.1.4.1.17484.2.6.2.1.1.6");
        element116.setName("Temperature Value6");
        element116.setUsability(true);
        element116.setRewritable(false);
        addNewElement(cbox, element116);

        Element element126 = new Element();
        element126.setOid("1.3.6.1.4.1.17484.2.6.2.1.2.6");
        element126.setName("ROM content6");
        element126.setUsability(true);
        element126.setRewritable(false);
        addNewElement(cbox, element126);

        Element element117 = new Element();
        element117.setOid("1.3.6.1.4.1.17484.2.6.2.1.1.7");
        element117.setName("Temperature Value7");
        element117.setUsability(true);
        element117.setRewritable(false);
        addNewElement(cbox, element117);

        Element element127 = new Element();
        element127.setOid("1.3.6.1.4.1.17484.2.6.2.1.2.7");
        element127.setName("ROM content7");
        element127.setUsability(true);
        element127.setRewritable(false);
        addNewElement(cbox, element127);

        Element element118 = new Element();
        element118.setOid("1.3.6.1.4.1.17484.2.6.2.1.1.8");
        element118.setName("Temperature Value8");
        element118.setUsability(true);
        element118.setRewritable(false);
        addNewElement(cbox, element118);

        Element element128 = new Element();
        element128.setOid("1.3.6.1.4.1.17484.2.6.2.1.2.8");
        element128.setName("ROM content8");
        element128.setUsability(true);
        element128.setRewritable(false);
        addNewElement(cbox, element128);

        Element element131 = new Element();
        element131.setOid("1.3.6.1.4.1.17484.2.9.2.1.1.1");
        element131.setName("tUP Value1");
        element131.setUsability(true);
        element131.setRewritable(true);
        addNewElement(cbox, element131);

        Element element132 = new Element();
        element132.setOid("1.3.6.1.4.1.17484.2.9.2.1.1.2");
        element132.setName("tUP Value2");
        element132.setUsability(true);
        element132.setRewritable(true);
        addNewElement(cbox, element132);

        Element element133 = new Element();
        element133.setOid("1.3.6.1.4.1.17484.2.9.2.1.1.3");
        element133.setName("tUP Value3");
        element133.setUsability(true);
        element133.setRewritable(true);
        addNewElement(cbox, element133);

        Element element134 = new Element();
        element134.setOid("1.3.6.1.4.1.17484.2.9.2.1.1.4");
        element134.setName("tUP Value4");
        element134.setUsability(true);
        element134.setRewritable(true);
        addNewElement(cbox, element134);

        Element element135 = new Element();
        element135.setOid("1.3.6.1.4.1.17484.2.9.2.1.1.5");
        element135.setName("tUP Value5");
        element135.setUsability(true);
        element135.setRewritable(true);
        addNewElement(cbox, element135);

        Element element136 = new Element();
        element136.setOid("1.3.6.1.4.1.17484.2.9.2.1.1.6");
        element136.setName("tUP Value6");
        element136.setUsability(true);
        element136.setRewritable(true);
        addNewElement(cbox, element136);

        Element element137 = new Element();
        element137.setOid("1.3.6.1.4.1.17484.2.9.2.1.1.7");
        element137.setName("tUP Value7");
        element137.setUsability(true);
        element137.setRewritable(true);
        addNewElement(cbox, element137);

        Element element138 = new Element();
        element138.setOid("1.3.6.1.4.1.17484.2.9.2.1.1.8");
        element138.setName("tUP Value8");
        element138.setUsability(true);
        element138.setRewritable(true);
        addNewElement(cbox, element138);

        Element element141 = new Element();
        element141.setOid("1.3.6.1.4.1.17484.2.9.2.1.2.1");
        element141.setName("tDWN Value1");
        element141.setUsability(true);
        element141.setRewritable(true);
        addNewElement(cbox, element141);

        Element element142 = new Element();
        element142.setOid("1.3.6.1.4.1.17484.2.9.2.1.2.2");
        element142.setName("tDWN Value2");
        element142.setUsability(true);
        element142.setRewritable(true);
        addNewElement(cbox, element142);

        Element element143 = new Element();
        element143.setOid("1.3.6.1.4.1.17484.2.9.2.1.2.3");
        element143.setName("tDWN Value3");
        element143.setUsability(true);
        element143.setRewritable(true);
        addNewElement(cbox, element143);

        Element element144 = new Element();
        element144.setOid("1.3.6.1.4.1.17484.2.9.2.1.2.4");
        element144.setName("tDWN Value4");
        element144.setUsability(true);
        element144.setRewritable(true);
        addNewElement(cbox, element144);

        Element element145 = new Element();
        element145.setOid("1.3.6.1.4.1.17484.2.9.2.1.2.5");
        element145.setName("tDWN Value5");
        element145.setUsability(true);
        element145.setRewritable(true);
        addNewElement(cbox, element145);

        Element element146 = new Element();
        element146.setOid("1.3.6.1.4.1.17484.2.9.2.1.2.6");
        element146.setName("tDWN Value6");
        element146.setUsability(true);
        element146.setRewritable(true);
        addNewElement(cbox, element146);

        Element element147 = new Element();
        element147.setOid("1.3.6.1.4.1.17484.2.9.2.1.2.7");
        element147.setName("tDWN Value7");
        element147.setUsability(true);
        element147.setRewritable(true);
        addNewElement(cbox, element147);

        Element element148 = new Element();
        element148.setOid("1.3.6.1.4.1.17484.2.9.2.1.2.8");
        element148.setName("tDWN Value8");
        element148.setUsability(true);
        element148.setRewritable(true);
        addNewElement(cbox, element148);

        Element element151 = new Element();
        element151.setOid("1.3.6.1.4.1.17484.2.9.2.1.3.1");
        element151.setName("DcSw0UpAction1");
        element151.setUsability(true);
        element151.setRewritable(true);
        addNewElement(cbox, element151);

        Element element152 = new Element();
        element152.setOid("1.3.6.1.4.1.17484.2.9.2.1.3.2");
        element152.setName("DcSw0UpAction2");
        element152.setUsability(true);
        element152.setRewritable(true);
        addNewElement(cbox, element152);

        Element element153 = new Element();
        element153.setOid("1.3.6.1.4.1.17484.2.9.2.1.3.3");
        element153.setName("DcSw0UpAction3");
        element153.setUsability(true);
        element153.setRewritable(true);
        addNewElement(cbox, element153);

        Element element154 = new Element();
        element154.setOid("1.3.6.1.4.1.17484.2.9.2.1.3.4");
        element154.setName("DcSw0UpAction4");
        element154.setUsability(true);
        element154.setRewritable(true);
        addNewElement(cbox, element154);

        Element element155 = new Element();
        element155.setOid("1.3.6.1.4.1.17484.2.9.2.1.3.5");
        element155.setName("DcSw0UpAction5");
        element155.setUsability(true);
        element155.setRewritable(true);
        addNewElement(cbox, element155);

        Element element156 = new Element();
        element156.setOid("1.3.6.1.4.1.17484.2.9.2.1.3.6");
        element156.setName("DcSw0UpAction6");
        element156.setUsability(true);
        element156.setRewritable(true);
        addNewElement(cbox, element156);

        Element element157 = new Element();
        element157.setOid("1.3.6.1.4.1.17484.2.9.2.1.3.7");
        element157.setName("DcSw0UpAction7");
        element157.setUsability(true);
        element157.setRewritable(true);
        addNewElement(cbox, element157);

        Element element158 = new Element();
        element158.setOid("1.3.6.1.4.1.17484.2.9.2.1.3.8");
        element158.setName("DcSw0UpAction8");
        element158.setUsability(true);
        element158.setRewritable(true);
        addNewElement(cbox, element158);

        Element element161 = new Element();
        element161.setOid("1.3.6.1.4.1.17484.2.9.2.1.4.1");
        element161.setName("DcSw0UpValue1");
        element161.setUsability(true);
        element161.setRewritable(true);
        addNewElement(cbox, element161);

        Element element162 = new Element();
        element162.setOid("1.3.6.1.4.1.17484.2.9.2.1.4.2");
        element162.setName("DcSw0UpValue2");
        element162.setUsability(true);
        element162.setRewritable(true);
        addNewElement(cbox, element162);

        Element element163 = new Element();
        element163.setOid("1.3.6.1.4.1.17484.2.9.2.1.4.3");
        element163.setName("DcSw0UpValue3");
        element163.setUsability(true);
        element163.setRewritable(true);
        addNewElement(cbox, element163);

        Element element164 = new Element();
        element164.setOid("1.3.6.1.4.1.17484.2.9.2.1.4.4");
        element164.setName("DcSw0UpValue4");
        element164.setUsability(true);
        element164.setRewritable(true);
        addNewElement(cbox, element164);

        Element element165 = new Element();
        element165.setOid("1.3.6.1.4.1.17484.2.9.2.1.4.5");
        element165.setName("DcSw0UpValue5");
        element165.setUsability(true);
        element165.setRewritable(true);
        addNewElement(cbox, element165);

        Element element166 = new Element();
        element166.setOid("1.3.6.1.4.1.17484.2.9.2.1.4.6");
        element166.setName("DcSw0UpValue6");
        element166.setUsability(true);
        element166.setRewritable(true);
        addNewElement(cbox, element166);

        Element element167 = new Element();
        element167.setOid("1.3.6.1.4.1.17484.2.9.2.1.4.7");
        element167.setName("DcSw0UpValue7");
        element167.setUsability(true);
        element167.setRewritable(true);
        addNewElement(cbox, element167);

        Element element168 = new Element();
        element168.setOid("1.3.6.1.4.1.17484.2.9.2.1.4.8");
        element168.setName("DcSw0UpValue8");
        element168.setUsability(true);
        element168.setRewritable(true);
        addNewElement(cbox, element168);

        Element element171 = new Element();
        element171.setOid("1.3.6.1.4.1.17484.2.9.2.1.5.1");
        element171.setName("DcSw0DwnAction1");
        element171.setUsability(true);
        element171.setRewritable(true);
        addNewElement(cbox, element171);

        Element element172 = new Element();
        element172.setOid("1.3.6.1.4.1.17484.2.9.2.1.5.2");
        element172.setName("DcSw0DwnAction2");
        element172.setUsability(true);
        element172.setRewritable(true);
        addNewElement(cbox, element172);

        Element element173 = new Element();
        element173.setOid("1.3.6.1.4.1.17484.2.9.2.1.5.3");
        element173.setName("DcSw0DwnAction3");
        element173.setUsability(true);
        element173.setRewritable(true);
        addNewElement(cbox, element173);

        Element element174 = new Element();
        element174.setOid("1.3.6.1.4.1.17484.2.9.2.1.5.4");
        element174.setName("DcSw0DwnAction4");
        element174.setUsability(true);
        element174.setRewritable(true);
        addNewElement(cbox, element174);

        Element element175 = new Element();
        element175.setOid("1.3.6.1.4.1.17484.2.9.2.1.5.5");
        element175.setName("DcSw0DwnAction5");
        element175.setUsability(true);
        element175.setRewritable(true);
        addNewElement(cbox, element175);

        Element element176 = new Element();
        element176.setOid("1.3.6.1.4.1.17484.2.9.2.1.5.6");
        element176.setName("DcSw0DwnAction6");
        element176.setUsability(true);
        element176.setRewritable(true);
        addNewElement(cbox, element176);

        Element element177 = new Element();
        element177.setOid("1.3.6.1.4.1.17484.2.9.2.1.5.7");
        element177.setName("DcSw0DwnAction7");
        element177.setUsability(true);
        element177.setRewritable(true);
        addNewElement(cbox, element177);

        Element element178 = new Element();
        element178.setOid("1.3.6.1.4.1.17484.2.9.2.1.5.8");
        element178.setName("DcSw0DwnAction8");
        element178.setUsability(true);
        element178.setRewritable(true);
        addNewElement(cbox, element178);

        Element element181 = new Element();
        element181.setOid("1.3.6.1.4.1.17484.2.9.2.1.6.1");
        element181.setName("DcSw0DwnValue1");
        element181.setUsability(true);
        element181.setRewritable(true);
        addNewElement(cbox, element181);

        Element element182 = new Element();
        element182.setOid("1.3.6.1.4.1.17484.2.9.2.1.6.2");
        element182.setName("DcSw0DwnValue2");
        element182.setUsability(true);
        element182.setRewritable(true);
        addNewElement(cbox, element182);

        Element element183 = new Element();
        element183.setOid("1.3.6.1.4.1.17484.2.9.2.1.6.3");
        element183.setName("DcSw0DwnValue3");
        element183.setUsability(true);
        element183.setRewritable(true);
        addNewElement(cbox, element183);

        Element element184 = new Element();
        element184.setOid("1.3.6.1.4.1.17484.2.9.2.1.6.4");
        element184.setName("DcSw0DwnValue4");
        element184.setUsability(true);
        element184.setRewritable(true);
        addNewElement(cbox, element184);

        Element element185 = new Element();
        element185.setOid("1.3.6.1.4.1.17484.2.9.2.1.6.5");
        element185.setName("DcSw0DwnValue5");
        element185.setUsability(true);
        element185.setRewritable(true);
        addNewElement(cbox, element185);

        Element element186 = new Element();
        element186.setOid("1.3.6.1.4.1.17484.2.9.2.1.6.6");
        element186.setName("DcSw0DwnValue6");
        element186.setUsability(true);
        element186.setRewritable(true);
        addNewElement(cbox, element186);

        Element element187 = new Element();
        element187.setOid("1.3.6.1.4.1.17484.2.9.2.1.6.7");
        element187.setName("DcSw0DwnValue7");
        element187.setUsability(true);
        element187.setRewritable(true);
        addNewElement(cbox, element187);

        Element element188 = new Element();
        element188.setOid("1.3.6.1.4.1.17484.2.9.2.1.6.8");
        element188.setName("DcSw0DwnValue8");
        element188.setUsability(true);
        element188.setRewritable(true);
        addNewElement(cbox, element188);

        Element element191 = new Element();
        element191.setOid("1.3.6.1.4.1.17484.2.9.2.1.7.1");
        element191.setName("DcSw1UpAction1");
        element191.setUsability(true);
        element191.setRewritable(true);
        addNewElement(cbox, element191);

        Element element192 = new Element();
        element192.setOid("1.3.6.1.4.1.17484.2.9.2.1.7.2");
        element192.setName("DcSw1UpAction2");
        element192.setUsability(true);
        element192.setRewritable(true);
        addNewElement(cbox, element192);

        Element element193 = new Element();
        element193.setOid("1.3.6.1.4.1.17484.2.9.2.1.7.3");
        element193.setName("DcSw1UpAction3");
        element193.setUsability(true);
        element193.setRewritable(true);
        addNewElement(cbox, element193);

        Element element194 = new Element();
        element194.setOid("1.3.6.1.4.1.17484.2.9.2.1.7.4");
        element194.setName("DcSw1UpAction4");
        element194.setUsability(true);
        element194.setRewritable(true);
        addNewElement(cbox, element194);

        Element element195 = new Element();
        element195.setOid("1.3.6.1.4.1.17484.2.9.2.1.7.5");
        element195.setName("DcSw1UpAction5");
        element195.setUsability(true);
        element195.setRewritable(true);
        addNewElement(cbox, element195);

        Element element196 = new Element();
        element196.setOid("1.3.6.1.4.1.17484.2.9.2.1.7.6");
        element196.setName("DcSw1UpAction6");
        element196.setUsability(true);
        element196.setRewritable(true);
        addNewElement(cbox, element196);

        Element element197 = new Element();
        element197.setOid("1.3.6.1.4.1.17484.2.9.2.1.7.7");
        element197.setName("DcSw1UpAction7");
        element197.setUsability(true);
        element197.setRewritable(true);
        addNewElement(cbox, element197);

        Element element198 = new Element();
        element198.setOid("1.3.6.1.4.1.17484.2.9.2.1.7.8");
        element198.setName("DcSw1UpAction8");
        element198.setUsability(true);
        element198.setRewritable(true);
        addNewElement(cbox, element198);

        Element element201 = new Element();
        element201.setOid("1.3.6.1.4.1.17484.2.9.2.1.8.1");
        element201.setName("DcSw1UpValue1");
        element201.setUsability(true);
        element201.setRewritable(true);
        addNewElement(cbox, element201);

        Element element202 = new Element();
        element202.setOid("1.3.6.1.4.1.17484.2.9.2.1.8.2");
        element202.setName("DcSw1UpValue2");
        element202.setUsability(true);
        element202.setRewritable(true);
        addNewElement(cbox, element202);

        Element element203 = new Element();
        element203.setOid("1.3.6.1.4.1.17484.2.9.2.1.8.3");
        element203.setName("DcSw1UpValue3");
        element203.setUsability(true);
        element203.setRewritable(true);
        addNewElement(cbox, element203);

        Element element204 = new Element();
        element204.setOid("1.3.6.1.4.1.17484.2.9.2.1.8.4");
        element204.setName("DcSw1UpValue4");
        element204.setUsability(true);
        element204.setRewritable(true);
        addNewElement(cbox, element204);

        Element element205 = new Element();
        element205.setOid("1.3.6.1.4.1.17484.2.9.2.1.8.5");
        element205.setName("DcSw1UpValue5");
        element205.setUsability(true);
        element205.setRewritable(true);
        addNewElement(cbox, element205);

        Element element206 = new Element();
        element206.setOid("1.3.6.1.4.1.17484.2.9.2.1.8.6");
        element206.setName("DcSw1UpValue6");
        element206.setUsability(true);
        element206.setRewritable(true);
        addNewElement(cbox, element206);

        Element element207 = new Element();
        element207.setOid("1.3.6.1.4.1.17484.2.9.2.1.8.7");
        element207.setName("DcSw1UpValue7");
        element207.setUsability(true);
        element207.setRewritable(true);
        addNewElement(cbox, element207);

        Element element208 = new Element();
        element208.setOid("1.3.6.1.4.1.17484.2.9.2.1.8.8");
        element208.setName("DcSw1UpValue8");
        element208.setUsability(true);
        element208.setRewritable(true);
        addNewElement(cbox, element208);

        Element element211 = new Element();
        element211.setOid("1.3.6.1.4.1.17484.2.9.2.1.9.1");
        element211.setName("DcSw1DwnAction1");
        element211.setUsability(true);
        element211.setRewritable(true);
        addNewElement(cbox, element211);

        Element element212 = new Element();
        element212.setOid("1.3.6.1.4.1.17484.2.9.2.1.9.2");
        element212.setName("DcSw1DwnAction2");
        element212.setUsability(true);
        element212.setRewritable(true);
        addNewElement(cbox, element212);

        Element element213 = new Element();
        element213.setOid("1.3.6.1.4.1.17484.2.9.2.1.9.3");
        element213.setName("DcSw1DwnAction3");
        element213.setUsability(true);
        element213.setRewritable(true);
        addNewElement(cbox, element213);

        Element element214 = new Element();
        element214.setOid("1.3.6.1.4.1.17484.2.9.2.1.9.4");
        element214.setName("DcSw1DwnAction4");
        element214.setUsability(true);
        element214.setRewritable(true);
        addNewElement(cbox, element214);

        Element element215 = new Element();
        element215.setOid("1.3.6.1.4.1.17484.2.9.2.1.9.5");
        element215.setName("DcSw1DwnAction5");
        element215.setUsability(true);
        element215.setRewritable(true);
        addNewElement(cbox, element215);

        Element element216 = new Element();
        element216.setOid("1.3.6.1.4.1.17484.2.9.2.1.9.6");
        element216.setName("DcSw1DwnAction6");
        element216.setUsability(true);
        element216.setRewritable(true);
        addNewElement(cbox, element216);

        Element element217 = new Element();
        element217.setOid("1.3.6.1.4.1.17484.2.9.2.1.9.7");
        element217.setName("DcSw1DwnAction7");
        element217.setUsability(true);
        element217.setRewritable(true);
        addNewElement(cbox, element217);

        Element element218 = new Element();
        element218.setOid("1.3.6.1.4.1.17484.2.9.2.1.9.8");
        element218.setName("DcSw1DwnAction8");
        element218.setUsability(true);
        element218.setRewritable(true);
        addNewElement(cbox, element218);

        Element element221 = new Element();
        element221.setOid("1.3.6.1.4.1.17484.2.9.2.1.10.1");
        element221.setName("DcSw1DwnValue1");
        element221.setUsability(true);
        element221.setRewritable(true);
        addNewElement(cbox, element221);

        Element element222 = new Element();
        element222.setOid("1.3.6.1.4.1.17484.2.9.2.1.10.2");
        element222.setName("DcSw1DwnValue2");
        element222.setUsability(true);
        element222.setRewritable(true);
        addNewElement(cbox, element222);

        Element element223 = new Element();
        element223.setOid("1.3.6.1.4.1.17484.2.9.2.1.10.3");
        element223.setName("DcSw1DwnValue3");
        element223.setUsability(true);
        element223.setRewritable(true);
        addNewElement(cbox, element223);

        Element element224 = new Element();
        element224.setOid("1.3.6.1.4.1.17484.2.9.2.1.10.4");
        element224.setName("DcSw1DwnValue4");
        element224.setUsability(true);
        element224.setRewritable(true);
        addNewElement(cbox, element224);

        Element element225 = new Element();
        element225.setOid("1.3.6.1.4.1.17484.2.9.2.1.10.5");
        element225.setName("DcSw1DwnValue5");
        element225.setUsability(true);
        element225.setRewritable(true);
        addNewElement(cbox, element225);

        Element element226 = new Element();
        element226.setOid("1.3.6.1.4.1.17484.2.9.2.1.10.6");
        element226.setName("DcSw1DwnValue6");
        element226.setUsability(true);
        element226.setRewritable(true);
        addNewElement(cbox, element226);

        Element element227 = new Element();
        element227.setOid("1.3.6.1.4.1.17484.2.9.2.1.10.7");
        element227.setName("DcSw1DwnValue7");
        element227.setUsability(true);
        element227.setRewritable(true);
        addNewElement(cbox, element227);

        Element element228 = new Element();
        element228.setOid("1.3.6.1.4.1.17484.2.9.2.1.10.8");
        element228.setName("DcSw1DwnValue8");
        element228.setUsability(true);
        element228.setRewritable(true);
        addNewElement(cbox, element228);

        Element element231 = new Element();
        element231.setOid("1.3.6.1.4.1.17484.2.9.2.1.11.1");
        element231.setName("DcSw2UpAction1");
        element231.setUsability(true);
        element231.setRewritable(true);
        addNewElement(cbox, element231);

        Element element232 = new Element();
        element232.setOid("1.3.6.1.4.1.17484.2.9.2.1.11.2");
        element232.setName("DcSw2UpAction2");
        element232.setUsability(true);
        element232.setRewritable(true);
        addNewElement(cbox, element232);

        Element element233 = new Element();
        element233.setOid("1.3.6.1.4.1.17484.2.9.2.1.11.3");
        element233.setName("DcSw2UpAction3");
        element233.setUsability(true);
        element233.setRewritable(true);
        addNewElement(cbox, element233);

        Element element234 = new Element();
        element234.setOid("1.3.6.1.4.1.17484.2.9.2.1.11.4");
        element234.setName("DcSw2UpAction4");
        element234.setUsability(true);
        element234.setRewritable(true);
        addNewElement(cbox, element234);

        Element element235 = new Element();
        element235.setOid("1.3.6.1.4.1.17484.2.9.2.1.11.5");
        element235.setName("DcSw2UpAction5");
        element235.setUsability(true);
        element235.setRewritable(true);
        addNewElement(cbox, element235);

        Element element236 = new Element();
        element236.setOid("1.3.6.1.4.1.17484.2.9.2.1.11.6");
        element236.setName("DcSw2UpAction6");
        element236.setUsability(true);
        element236.setRewritable(true);
        addNewElement(cbox, element236);

        Element element237 = new Element();
        element237.setOid("1.3.6.1.4.1.17484.2.9.2.1.11.7");
        element237.setName("DcSw2UpAction7");
        element237.setUsability(true);
        element237.setRewritable(true);
        addNewElement(cbox, element237);

        Element element238 = new Element();
        element238.setOid("1.3.6.1.4.1.17484.2.9.2.1.11.8");
        element238.setName("DcSw2UpAction8");
        element238.setUsability(true);
        element238.setRewritable(true);
        addNewElement(cbox, element238);

        Element element241 = new Element();
        element241.setOid("1.3.6.1.4.1.17484.2.9.2.1.12.1");
        element241.setName("DcSw2UpValue1");
        element241.setUsability(true);
        element241.setRewritable(true);
        addNewElement(cbox, element241);

        Element element242 = new Element();
        element242.setOid("1.3.6.1.4.1.17484.2.9.2.1.12.2");
        element242.setName("DcSw2UpValue2");
        element242.setUsability(true);
        element242.setRewritable(true);
        addNewElement(cbox, element242);

        Element element243 = new Element();
        element243.setOid("1.3.6.1.4.1.17484.2.9.2.1.12.3");
        element243.setName("DcSw2UpValue3");
        element243.setUsability(true);
        element243.setRewritable(true);
        addNewElement(cbox, element243);

        Element element244 = new Element();
        element244.setOid("1.3.6.1.4.1.17484.2.9.2.1.12.4");
        element244.setName("DcSw2UpValue4");
        element244.setUsability(true);
        element244.setRewritable(true);
        addNewElement(cbox, element244);

        Element element245 = new Element();
        element245.setOid("1.3.6.1.4.1.17484.2.9.2.1.12.5");
        element245.setName("DcSw2UpValue5");
        element245.setUsability(true);
        element245.setRewritable(true);
        addNewElement(cbox, element245);

        Element element246 = new Element();
        element246.setOid("1.3.6.1.4.1.17484.2.9.2.1.12.6");
        element246.setName("DcSw2UpValue6");
        element246.setUsability(true);
        element246.setRewritable(true);
        addNewElement(cbox, element246);

        Element element247 = new Element();
        element247.setOid("1.3.6.1.4.1.17484.2.9.2.1.12.7");
        element247.setName("DcSw2UpValue7");
        element247.setUsability(true);
        element247.setRewritable(true);
        addNewElement(cbox, element247);

        Element element248 = new Element();
        element248.setOid("1.3.6.1.4.1.17484.2.9.2.1.12.8");
        element248.setName("DcSw2UpValue8");
        element248.setUsability(true);
        element248.setRewritable(true);
        addNewElement(cbox, element248);

        Element element251 = new Element();
        element251.setOid("1.3.6.1.4.1.17484.2.9.2.1.13.1");
        element251.setName("DcSw2DwnAction1");
        element251.setUsability(true);
        element251.setRewritable(true);
        addNewElement(cbox, element251);

        Element element252 = new Element();
        element252.setOid("1.3.6.1.4.1.17484.2.9.2.1.13.2");
        element252.setName("DcSw2DwnAction2");
        element252.setUsability(true);
        element252.setRewritable(true);
        addNewElement(cbox, element252);

        Element element253 = new Element();
        element253.setOid("1.3.6.1.4.1.17484.2.9.2.1.13.3");
        element253.setName("DcSw2DwnAction3");
        element253.setUsability(true);
        element253.setRewritable(true);
        addNewElement(cbox, element253);

        Element element254 = new Element();
        element254.setOid("1.3.6.1.4.1.17484.2.9.2.1.13.4");
        element254.setName("DcSw2DwnAction4");
        element254.setUsability(true);
        element254.setRewritable(true);
        addNewElement(cbox, element254);

        Element element255 = new Element();
        element255.setOid("1.3.6.1.4.1.17484.2.9.2.1.13.5");
        element255.setName("DcSw2DwnAction5");
        element255.setUsability(true);
        element255.setRewritable(true);
        addNewElement(cbox, element255);

        Element element256 = new Element();
        element256.setOid("1.3.6.1.4.1.17484.2.9.2.1.13.6");
        element256.setName("DcSw2DwnAction6");
        element256.setUsability(true);
        element256.setRewritable(true);
        addNewElement(cbox, element256);

        Element element257 = new Element();
        element257.setOid("1.3.6.1.4.1.17484.2.9.2.1.13.7");
        element257.setName("DcSw2DwnAction7");
        element257.setUsability(true);
        element257.setRewritable(true);
        addNewElement(cbox, element257);

        Element element258 = new Element();
        element258.setOid("1.3.6.1.4.1.17484.2.9.2.1.13.8");
        element258.setName("DcSw2DwnAction8");
        element258.setUsability(true);
        element258.setRewritable(true);
        addNewElement(cbox, element258);

        Element element261 = new Element();
        element261.setOid("1.3.6.1.4.1.17484.2.9.2.1.14.1");
        element261.setName("DcSw2DwnValue1");
        element261.setUsability(true);
        element261.setRewritable(true);
        addNewElement(cbox, element261);

        Element element262 = new Element();
        element262.setOid("1.3.6.1.4.1.17484.2.9.2.1.14.2");
        element262.setName("DcSw2DwnValue2");
        element262.setUsability(true);
        element262.setRewritable(true);
        addNewElement(cbox, element262);

        Element element263 = new Element();
        element263.setOid("1.3.6.1.4.1.17484.2.9.2.1.14.3");
        element263.setName("DcSw2DwnValue3");
        element263.setUsability(true);
        element263.setRewritable(true);
        addNewElement(cbox, element263);

        Element element264 = new Element();
        element264.setOid("1.3.6.1.4.1.17484.2.9.2.1.14.4");
        element264.setName("DcSw2DwnValue4");
        element264.setUsability(true);
        element264.setRewritable(true);
        addNewElement(cbox, element264);

        Element element265 = new Element();
        element265.setOid("1.3.6.1.4.1.17484.2.9.2.1.14.5");
        element265.setName("DcSw2DwnValue5");
        element265.setUsability(true);
        element265.setRewritable(true);
        addNewElement(cbox, element265);

        Element element266 = new Element();
        element266.setOid("1.3.6.1.4.1.17484.2.9.2.1.14.6");
        element266.setName("DcSw2DwnValue6");
        element266.setUsability(true);
        element266.setRewritable(true);
        addNewElement(cbox, element266);

        Element element267 = new Element();
        element267.setOid("1.3.6.1.4.1.17484.2.9.2.1.14.7");
        element267.setName("DcSw2DwnValue7");
        element267.setUsability(true);
        element267.setRewritable(true);
        addNewElement(cbox, element267);

        Element element268 = new Element();
        element268.setOid("1.3.6.1.4.1.17484.2.9.2.1.14.8");
        element268.setName("DcSw2DwnValue8");
        element268.setUsability(true);
        element268.setRewritable(true);
        addNewElement(cbox, element268);

        Element element271 = new Element();
        element271.setOid("1.3.6.1.4.1.17484.2.9.2.1.15.1");
        element271.setName("DcSw3UpAction1");
        element271.setUsability(true);
        element271.setRewritable(true);
        addNewElement(cbox, element271);

        Element element272 = new Element();
        element272.setOid("1.3.6.1.4.1.17484.2.9.2.1.15.2");
        element272.setName("DcSw3UpAction2");
        element272.setUsability(true);
        element272.setRewritable(true);
        addNewElement(cbox, element272);

        Element element273 = new Element();
        element273.setOid("1.3.6.1.4.1.17484.2.9.2.1.15.3");
        element273.setName("DcSw3UpAction3");
        element273.setUsability(true);
        element273.setRewritable(true);
        addNewElement(cbox, element273);

        Element element274 = new Element();
        element274.setOid("1.3.6.1.4.1.17484.2.9.2.1.15.4");
        element274.setName("DcSw3UpAction4");
        element274.setUsability(true);
        element274.setRewritable(true);
        addNewElement(cbox, element274);

        Element element275 = new Element();
        element275.setOid("1.3.6.1.4.1.17484.2.9.2.1.15.5");
        element275.setName("DcSw3UpAction5");
        element275.setUsability(true);
        element275.setRewritable(true);
        addNewElement(cbox, element275);

        Element element276 = new Element();
        element276.setOid("1.3.6.1.4.1.17484.2.9.2.1.15.6");
        element276.setName("DcSw3UpAction6");
        element276.setUsability(true);
        element276.setRewritable(true);
        addNewElement(cbox, element276);

        Element element277 = new Element();
        element277.setOid("1.3.6.1.4.1.17484.2.9.2.1.15.7");
        element277.setName("DcSw3UpAction7");
        element277.setUsability(true);
        element277.setRewritable(true);
        addNewElement(cbox, element277);

        Element element278 = new Element();
        element278.setOid("1.3.6.1.4.1.17484.2.9.2.1.15.8");
        element278.setName("DcSw3UpAction8");
        element278.setUsability(true);
        element278.setRewritable(true);
        addNewElement(cbox, element278);

        Element element281 = new Element();
        element281.setOid("1.3.6.1.4.1.17484.2.9.2.1.16.1");
        element281.setName("DcSw3UpValue1");
        element281.setUsability(true);
        element281.setRewritable(true);
        addNewElement(cbox, element281);

        Element element282 = new Element();
        element282.setOid("1.3.6.1.4.1.17484.2.9.2.1.16.2");
        element282.setName("DcSw3UpValue2");
        element282.setUsability(true);
        element282.setRewritable(true);
        addNewElement(cbox, element282);

        Element element283 = new Element();
        element283.setOid("1.3.6.1.4.1.17484.2.9.2.1.16.3");
        element283.setName("DcSw3UpValue3");
        element283.setUsability(true);
        element283.setRewritable(true);
        addNewElement(cbox, element283);

        Element element284 = new Element();
        element284.setOid("1.3.6.1.4.1.17484.2.9.2.1.16.4");
        element284.setName("DcSw3UpValue4");
        element284.setUsability(true);
        element284.setRewritable(true);
        addNewElement(cbox, element284);

        Element element285 = new Element();
        element285.setOid("1.3.6.1.4.1.17484.2.9.2.1.16.5");
        element285.setName("DcSw3UpValue5");
        element285.setUsability(true);
        element285.setRewritable(true);
        addNewElement(cbox, element285);

        Element element286 = new Element();
        element286.setOid("1.3.6.1.4.1.17484.2.9.2.1.16.6");
        element286.setName("DcSw3UpValue6");
        element286.setUsability(true);
        element286.setRewritable(true);
        addNewElement(cbox, element286);

        Element element287 = new Element();
        element287.setOid("1.3.6.1.4.1.17484.2.9.2.1.16.7");
        element287.setName("DcSw3UpValue7");
        element287.setUsability(true);
        element287.setRewritable(true);
        addNewElement(cbox, element287);

        Element element288 = new Element();
        element288.setOid("1.3.6.1.4.1.17484.2.9.2.1.16.8");
        element288.setName("DcSw3UpValue8");
        element288.setUsability(true);
        element288.setRewritable(true);
        addNewElement(cbox, element288);

        Element element291 = new Element();
        element291.setOid("1.3.6.1.4.1.17484.2.9.2.1.17.1");
        element291.setName("DcSw3DwnAction1");
        element291.setUsability(true);
        element291.setRewritable(true);
        addNewElement(cbox, element291);

        Element element292 = new Element();
        element292.setOid("1.3.6.1.4.1.17484.2.9.2.1.17.2");
        element292.setName("DcSw3DwnAction2");
        element292.setUsability(true);
        element292.setRewritable(true);
        addNewElement(cbox, element292);

        Element element293 = new Element();
        element293.setOid("1.3.6.1.4.1.17484.2.9.2.1.17.3");
        element293.setName("DcSw3DwnAction3");
        element293.setUsability(true);
        element293.setRewritable(true);
        addNewElement(cbox, element293);

        Element element294 = new Element();
        element294.setOid("1.3.6.1.4.1.17484.2.9.2.1.17.4");
        element294.setName("DcSw3DwnAction4");
        element294.setUsability(true);
        element294.setRewritable(true);
        addNewElement(cbox, element294);

        Element element295 = new Element();
        element295.setOid("1.3.6.1.4.1.17484.2.9.2.1.17.5");
        element295.setName("DcSw3DwnAction5");
        element295.setUsability(true);
        element295.setRewritable(true);
        addNewElement(cbox, element295);

        Element element296 = new Element();
        element296.setOid("1.3.6.1.4.1.17484.2.9.2.1.17.6");
        element296.setName("DcSw3DwnAction6");
        element296.setUsability(true);
        element296.setRewritable(true);
        addNewElement(cbox, element296);

        Element element297 = new Element();
        element297.setOid("1.3.6.1.4.1.17484.2.9.2.1.17.7");
        element297.setName("DcSw3DwnAction7");
        element297.setUsability(true);
        element297.setRewritable(true);
        addNewElement(cbox, element297);

        Element element298 = new Element();
        element298.setOid("1.3.6.1.4.1.17484.2.9.2.1.17.8");
        element298.setName("DcSw3DwnAction8");
        element298.setUsability(true);
        element298.setRewritable(true);
        addNewElement(cbox, element298);

        Element element301 = new Element();
        element301.setOid("1.3.6.1.4.1.17484.2.9.2.1.18.1");
        element301.setName("DcSw3DwnValue1");
        element301.setUsability(true);
        element301.setRewritable(true);
        addNewElement(cbox, element301);

        Element element302 = new Element();
        element302.setOid("1.3.6.1.4.1.17484.2.9.2.1.18.2");
        element302.setName("DcSw3DwnValue2");
        element302.setUsability(true);
        element302.setRewritable(true);
        addNewElement(cbox, element302);

        Element element303 = new Element();
        element303.setOid("1.3.6.1.4.1.17484.2.9.2.1.18.3");
        element303.setName("DcSw3DwnValue3");
        element303.setUsability(true);
        element303.setRewritable(true);
        addNewElement(cbox, element303);

        Element element304 = new Element();
        element304.setOid("1.3.6.1.4.1.17484.2.9.2.1.18.4");
        element304.setName("DcSw3DwnValue4");
        element304.setUsability(true);
        element304.setRewritable(true);
        addNewElement(cbox, element304);

        Element element305 = new Element();
        element305.setOid("1.3.6.1.4.1.17484.2.9.2.1.18.5");
        element305.setName("DcSw3DwnValue5");
        element305.setUsability(true);
        element305.setRewritable(true);
        addNewElement(cbox, element305);

        Element element306 = new Element();
        element306.setOid("1.3.6.1.4.1.17484.2.9.2.1.18.6");
        element306.setName("DcSw3DwnValue6");
        element306.setUsability(true);
        element306.setRewritable(true);
        addNewElement(cbox, element306);

        Element element307 = new Element();
        element307.setOid("1.3.6.1.4.1.17484.2.9.2.1.18.7");
        element307.setName("DcSw3DwnValue7");
        element307.setUsability(true);
        element307.setRewritable(true);
        addNewElement(cbox, element307);

        Element element308 = new Element();
        element308.setOid("1.3.6.1.4.1.17484.2.9.2.1.18.8");
        element308.setName("DcSw3DwnValue8");
        element308.setUsability(true);
        element308.setRewritable(true);
        addNewElement(cbox, element308);

        Element element311 = new Element();
        element311.setOid("1.3.6.1.4.1.17484.2.9.2.1.19.1");
        element311.setName("AcSwUpAction1");
        element311.setUsability(true);
        element311.setRewritable(true);
        addNewElement(cbox, element311);

        Element element312 = new Element();
        element312.setOid("1.3.6.1.4.1.17484.2.9.2.1.19.2");
        element312.setName("AcSwUpAction2");
        element312.setUsability(true);
        element312.setRewritable(true);
        addNewElement(cbox, element312);

        Element element313 = new Element();
        element313.setOid("1.3.6.1.4.1.17484.2.9.2.1.19.3");
        element313.setName("AcSwUpAction3");
        element313.setUsability(true);
        element313.setRewritable(true);
        addNewElement(cbox, element313);

        Element element314 = new Element();
        element314.setOid("1.3.6.1.4.1.17484.2.9.2.1.19.4");
        element314.setName("AcSwUpAction4");
        element314.setUsability(true);
        element314.setRewritable(true);
        addNewElement(cbox, element314);

        Element element315 = new Element();
        element315.setOid("1.3.6.1.4.1.17484.2.9.2.1.19.5");
        element315.setName("AcSwUpAction5");
        element315.setUsability(true);
        element315.setRewritable(true);
        addNewElement(cbox, element315);

        Element element316 = new Element();
        element316.setOid("1.3.6.1.4.1.17484.2.9.2.1.19.6");
        element316.setName("AcSwUpAction6");
        element316.setUsability(true);
        element316.setRewritable(true);
        addNewElement(cbox, element316);

        Element element317 = new Element();
        element317.setOid("1.3.6.1.4.1.17484.2.9.2.1.19.7");
        element317.setName("AcSwUpAction7");
        element317.setUsability(true);
        element317.setRewritable(true);
        addNewElement(cbox, element317);

        Element element318 = new Element();
        element318.setOid("1.3.6.1.4.1.17484.2.9.2.1.19.8");
        element318.setName("AcSwUpAction8");
        element318.setUsability(true);
        element318.setRewritable(true);
        addNewElement(cbox, element318);

        Element element321 = new Element();
        element321.setOid("1.3.6.1.4.1.17484.2.9.2.1.20.1");
        element321.setName("AcSwUpValue1");
        element321.setUsability(true);
        element321.setRewritable(true);
        addNewElement(cbox, element321);

        Element element322 = new Element();
        element322.setOid("1.3.6.1.4.1.17484.2.9.2.1.20.2");
        element322.setName("AcSwUpValue2");
        element322.setUsability(true);
        element322.setRewritable(true);
        addNewElement(cbox, element322);

        Element element323 = new Element();
        element323.setOid("1.3.6.1.4.1.17484.2.9.2.1.20.3");
        element323.setName("AcSwUpValue3");
        element323.setUsability(true);
        element323.setRewritable(true);
        addNewElement(cbox, element323);

        Element element324 = new Element();
        element324.setOid("1.3.6.1.4.1.17484.2.9.2.1.20.4");
        element324.setName("AcSwUpValue4");
        element324.setUsability(true);
        element324.setRewritable(true);
        addNewElement(cbox, element324);

        Element element325 = new Element();
        element325.setOid("1.3.6.1.4.1.17484.2.9.2.1.20.5");
        element325.setName("AcSwUpValue5");
        element325.setUsability(true);
        element325.setRewritable(true);
        addNewElement(cbox, element325);

        Element element326 = new Element();
        element326.setOid("1.3.6.1.4.1.17484.2.9.2.1.20.6");
        element326.setName("AcSwUpValue6");
        element326.setUsability(true);
        element326.setRewritable(true);
        addNewElement(cbox, element326);

        Element element327 = new Element();
        element327.setOid("1.3.6.1.4.1.17484.2.9.2.1.20.7");
        element327.setName("AcSwUpValue7");
        element327.setUsability(true);
        element327.setRewritable(true);
        addNewElement(cbox, element327);

        Element element328 = new Element();
        element328.setOid("1.3.6.1.4.1.17484.2.9.2.1.20.8");
        element328.setName("AcSwUpValue8");
        element328.setUsability(true);
        element328.setRewritable(true);
        addNewElement(cbox, element328);

        Element element331 = new Element();
        element331.setOid("1.3.6.1.4.1.17484.2.9.2.1.21.1");
        element331.setName("AcSwDwnAction1");
        element331.setUsability(true);
        element331.setRewritable(true);
        addNewElement(cbox, element331);

        Element element332 = new Element();
        element332.setOid("1.3.6.1.4.1.17484.2.9.2.1.21.2");
        element332.setName("AcSwDwnAction2");
        element332.setUsability(true);
        element332.setRewritable(true);
        addNewElement(cbox, element332);

        Element element333 = new Element();
        element333.setOid("1.3.6.1.4.1.17484.2.9.2.1.21.3");
        element333.setName("AcSwDwnAction3");
        element333.setUsability(true);
        element333.setRewritable(true);
        addNewElement(cbox, element333);

        Element element334 = new Element();
        element334.setOid("1.3.6.1.4.1.17484.2.9.2.1.21.4");
        element334.setName("AcSwDwnAction4");
        element334.setUsability(true);
        element334.setRewritable(true);
        addNewElement(cbox, element334);

        Element element335 = new Element();
        element335.setOid("1.3.6.1.4.1.17484.2.9.2.1.21.5");
        element335.setName("AcSwDwnAction5");
        element335.setUsability(true);
        element335.setRewritable(true);
        addNewElement(cbox, element335);

        Element element336 = new Element();
        element336.setOid("1.3.6.1.4.1.17484.2.9.2.1.21.6");
        element336.setName("AcSwDwnAction6");
        element336.setUsability(true);
        element336.setRewritable(true);
        addNewElement(cbox, element336);

        Element element337 = new Element();
        element337.setOid("1.3.6.1.4.1.17484.2.9.2.1.21.7");
        element337.setName("AcSwDwnAction7");
        element337.setUsability(true);
        element337.setRewritable(true);
        addNewElement(cbox, element337);

        Element element338 = new Element();
        element338.setOid("1.3.6.1.4.1.17484.2.9.2.1.21.8");
        element338.setName("AcSwDwnAction8");
        element338.setUsability(true);
        element338.setRewritable(true);
        addNewElement(cbox, element338);

        Element element341 = new Element();
        element341.setOid("1.3.6.1.4.1.17484.2.9.2.1.22.1");
        element341.setName("AcSwDwnValue1");
        element341.setUsability(true);
        element341.setRewritable(true);
        addNewElement(cbox, element341);

        Element element342 = new Element();
        element342.setOid("1.3.6.1.4.1.17484.2.9.2.1.22.2");
        element342.setName("AcSwDwnValue2");
        element342.setUsability(true);
        element342.setRewritable(true);
        addNewElement(cbox, element342);

        Element element343 = new Element();
        element343.setOid("1.3.6.1.4.1.17484.2.9.2.1.22.3");
        element343.setName("AcSwDwnValue3");
        element343.setUsability(true);
        element343.setRewritable(true);
        addNewElement(cbox, element343);

        Element element344 = new Element();
        element344.setOid("1.3.6.1.4.1.17484.2.9.2.1.22.4");
        element344.setName("AcSwDwnValue4");
        element344.setUsability(true);
        element344.setRewritable(true);
        addNewElement(cbox, element344);

        Element element345 = new Element();
        element345.setOid("1.3.6.1.4.1.17484.2.9.2.1.22.5");
        element345.setName("AcSwDwnValue5");
        element345.setUsability(true);
        element345.setRewritable(true);
        addNewElement(cbox, element345);

        Element element346 = new Element();
        element346.setOid("1.3.6.1.4.1.17484.2.9.2.1.22.6");
        element346.setName("AcSwDwnValue6");
        element346.setUsability(true);
        element346.setRewritable(true);
        addNewElement(cbox, element346);

        Element element347 = new Element();
        element347.setOid("1.3.6.1.4.1.17484.2.9.2.1.22.7");
        element347.setName("AcSwDwnValue7");
        element347.setUsability(true);
        element347.setRewritable(true);
        addNewElement(cbox, element347);

        Element element348 = new Element();
        element348.setOid("1.3.6.1.4.1.17484.2.9.2.1.22.8");
        element348.setName("AcSwDwnValue8");
        element348.setUsability(true);
        element348.setRewritable(true);
        addNewElement(cbox, element348);

        Element element351 = new Element();
        element351.setOid("1.3.6.1.4.1.17484.2.9.2.1.23.1");
        element351.setName("TupTrapFlag1");
        element351.setUsability(true);
        element351.setRewritable(true);
        addNewElement(cbox, element351);

        Element element352 = new Element();
        element352.setOid("1.3.6.1.4.1.17484.2.9.2.1.23.2");
        element352.setName("TupTrapFlag2");
        element352.setUsability(true);
        element352.setRewritable(true);
        addNewElement(cbox, element352);

        Element element353 = new Element();
        element353.setOid("1.3.6.1.4.1.17484.2.9.2.1.23.3");
        element353.setName("TupTrapFlag3");
        element353.setUsability(true);
        element353.setRewritable(true);
        addNewElement(cbox, element353);

        Element element354 = new Element();
        element354.setOid("1.3.6.1.4.1.17484.2.9.2.1.23.4");
        element354.setName("TupTrapFlag4");
        element354.setUsability(true);
        element354.setRewritable(true);
        addNewElement(cbox, element354);

        Element element355 = new Element();
        element355.setOid("1.3.6.1.4.1.17484.2.9.2.1.23.5");
        element355.setName("TupTrapFlag5");
        element355.setUsability(true);
        element355.setRewritable(true);
        addNewElement(cbox, element355);

        Element element356 = new Element();
        element356.setOid("1.3.6.1.4.1.17484.2.9.2.1.23.6");
        element356.setName("TupTrapFlag6");
        element356.setUsability(true);
        element356.setRewritable(true);
        addNewElement(cbox, element356);

        Element element357 = new Element();
        element357.setOid("1.3.6.1.4.1.17484.2.9.2.1.23.7");
        element357.setName("TupTrapFlag7");
        element357.setUsability(true);
        element357.setRewritable(true);
        addNewElement(cbox, element357);

        Element element358 = new Element();
        element358.setOid("1.3.6.1.4.1.17484.2.9.2.1.23.8");
        element358.setName("TupTrapFlag8");
        element358.setUsability(true);
        element358.setRewritable(true);
        addNewElement(cbox, element358);

        Element element361 = new Element();
        element361.setOid("1.3.6.1.4.1.17484.2.9.2.1.24.1");
        element361.setName("TdwnTrapFlag1");
        element361.setUsability(true);
        element361.setRewritable(true);
        addNewElement(cbox, element361);

        Element element362 = new Element();
        element362.setOid("1.3.6.1.4.1.17484.2.9.2.1.24.2");
        element362.setName("TdwnTrapFlag2");
        element362.setUsability(true);
        element362.setRewritable(true);
        addNewElement(cbox, element362);

        Element element363 = new Element();
        element363.setOid("1.3.6.1.4.1.17484.2.9.2.1.24.3");
        element363.setName("TdwnTrapFlag3");
        element363.setUsability(true);
        element363.setRewritable(true);
        addNewElement(cbox, element363);

        Element element364 = new Element();
        element364.setOid("1.3.6.1.4.1.17484.2.9.2.1.24.4");
        element364.setName("TdwnTrapFlag4");
        element364.setUsability(true);
        element364.setRewritable(true);
        addNewElement(cbox, element364);

        Element element365 = new Element();
        element365.setOid("1.3.6.1.4.1.17484.2.9.2.1.24.5");
        element365.setName("TdwnTrapFlag5");
        element365.setUsability(true);
        element365.setRewritable(true);
        addNewElement(cbox, element365);

        Element element366 = new Element();
        element366.setOid("1.3.6.1.4.1.17484.2.9.2.1.24.6");
        element366.setName("TdwnTrapFlag6");
        element366.setUsability(true);
        element366.setRewritable(true);
        addNewElement(cbox, element366);

        Element element367 = new Element();
        element367.setOid("1.3.6.1.4.1.17484.2.9.2.1.24.7");
        element367.setName("TdwnTrapFlag7");
        element367.setUsability(true);
        element367.setRewritable(true);
        addNewElement(cbox, element367);

        Element element368 = new Element();
        element368.setOid("1.3.6.1.4.1.17484.2.9.2.1.24.8");
        element368.setName("TdwnTrapFlag8");
        element368.setUsability(true);
        element368.setRewritable(true);
        addNewElement(cbox, element368);

        Element element371 = new Element();
        element371.setOid("1.3.6.1.4.1.17484.2.7.2.1.1.1");
        element371.setName("Ping IP address1");
        element371.setUsability(true);
        element371.setRewritable(true);
        addNewElement(cbox, element371);

        Element element372 = new Element();
        element372.setOid("1.3.6.1.4.1.17484.2.7.2.1.1.2");
        element372.setName("Ping IP address2");
        element372.setUsability(true);
        element372.setRewritable(true);
        addNewElement(cbox, element372);

        Element element373 = new Element();
        element373.setOid("1.3.6.1.4.1.17484.2.7.2.1.1.3");
        element373.setName("Ping IP address3");
        element373.setUsability(true);
        element373.setRewritable(true);
        addNewElement(cbox, element373);

        Element element374 = new Element();
        element374.setOid("1.3.6.1.4.1.17484.2.7.2.1.1.4");
        element374.setName("Ping IP address4");
        element374.setUsability(true);
        element374.setRewritable(true);
        addNewElement(cbox, element374);

        Element element381 = new Element();
        element381.setOid("1.3.6.1.4.1.17484.2.7.2.1.2.1");
        element381.setName("Ping Period Value1");
        element381.setUsability(true);
        element381.setRewritable(true);
        addNewElement(cbox, element381);

        Element element382 = new Element();
        element382.setOid("1.3.6.1.4.1.17484.2.7.2.1.2.2");
        element382.setName("Ping Period Value2");
        element382.setUsability(true);
        element382.setRewritable(true);
        addNewElement(cbox, element382);

        Element element383 = new Element();
        element383.setOid("1.3.6.1.4.1.17484.2.7.2.1.2.3");
        element383.setName("Ping Period Value3");
        element383.setUsability(true);
        element383.setRewritable(true);
        addNewElement(cbox, element383);

        Element element384 = new Element();
        element384.setOid("1.3.6.1.4.1.17484.2.7.2.1.2.4");
        element384.setName("Ping Period Value4");
        element384.setUsability(true);
        element384.setRewritable(true);
        addNewElement(cbox, element384);

        Element element391 = new Element();
        element391.setOid("1.3.6.1.4.1.17484.2.7.2.1.3.1");
        element391.setName("Ping TimeOut Value1");
        element391.setUsability(true);
        element391.setRewritable(true);
        addNewElement(cbox, element391);

        Element element392 = new Element();
        element392.setOid("1.3.6.1.4.1.17484.2.7.2.1.3.2");
        element392.setName("Ping TimeOut Value2");
        element392.setUsability(true);
        element392.setRewritable(true);
        addNewElement(cbox, element392);

        Element element393 = new Element();
        element393.setOid("1.3.6.1.4.1.17484.2.7.2.1.3.3");
        element393.setName("Ping TimeOut Value3");
        element393.setUsability(true);
        element393.setRewritable(true);
        addNewElement(cbox, element393);

        Element element394 = new Element();
        element394.setOid("1.3.6.1.4.1.17484.2.7.2.1.3.4");
        element394.setName("Ping TimeOut Value4");
        element394.setUsability(true);
        element394.setRewritable(true);
        addNewElement(cbox, element394);

        Element element401 = new Element();
        element401.setOid("1.3.6.1.4.1.17484.2.7.2.1.4.1");
        element401.setName("Ping DcSw0 Action1");
        element401.setUsability(true);
        element401.setRewritable(true);
        addNewElement(cbox, element401);

        Element element402 = new Element();
        element402.setOid("1.3.6.1.4.1.17484.2.7.2.1.4.2");
        element402.setName("Ping DcSw0 Action2");
        element402.setUsability(true);
        element402.setRewritable(true);
        addNewElement(cbox, element402);

        Element element403 = new Element();
        element403.setOid("1.3.6.1.4.1.17484.2.7.2.1.4.3");
        element403.setName("Ping DcSw0 Action3");
        element403.setUsability(true);
        element403.setRewritable(true);
        addNewElement(cbox, element403);

        Element element404 = new Element();
        element404.setOid("1.3.6.1.4.1.17484.2.7.2.1.4.4");
        element404.setName("Ping DcSw0 Action4");
        element404.setUsability(true);
        element404.setRewritable(true);
        addNewElement(cbox, element404);

        Element element411 = new Element();
        element411.setOid("1.3.6.1.4.1.17484.2.7.2.1.5.1");
        element411.setName("Ping DcSw0 Value1");
        element411.setUsability(true);
        element411.setRewritable(true);
        addNewElement(cbox, element411);

        Element element412 = new Element();
        element412.setOid("1.3.6.1.4.1.17484.2.7.2.1.5.2");
        element412.setName("Ping DcSw0 Value2");
        element412.setUsability(true);
        element412.setRewritable(true);
        addNewElement(cbox, element412);

        Element element413 = new Element();
        element413.setOid("1.3.6.1.4.1.17484.2.7.2.1.5.3");
        element413.setName("Ping DcSw0 Value3");
        element413.setUsability(true);
        element413.setRewritable(true);
        addNewElement(cbox, element413);

        Element element414 = new Element();
        element414.setOid("1.3.6.1.4.1.17484.2.7.2.1.5.4");
        element414.setName("Ping DcSw0 Value4");
        element414.setUsability(true);
        element414.setRewritable(true);
        addNewElement(cbox, element414);

        Element element421 = new Element();
        element421.setOid("1.3.6.1.4.1.17484.2.7.2.1.6.1");
        element421.setName("Ping DcSw1 Action1");
        element421.setUsability(true);
        element421.setRewritable(true);
        addNewElement(cbox, element421);

        Element element422 = new Element();
        element422.setOid("1.3.6.1.4.1.17484.2.7.2.1.6.2");
        element422.setName("Ping DcSw1 Action2");
        element422.setUsability(true);
        element422.setRewritable(true);
        addNewElement(cbox, element422);

        Element element423 = new Element();
        element423.setOid("1.3.6.1.4.1.17484.2.7.2.1.6.3");
        element423.setName("Ping DcSw1 Action3");
        element423.setUsability(true);
        element423.setRewritable(true);
        addNewElement(cbox, element423);

        Element element424 = new Element();
        element424.setOid("1.3.6.1.4.1.17484.2.7.2.1.6.4");
        element424.setName("Ping DcSw1 Action4");
        element424.setUsability(true);
        element424.setRewritable(true);
        addNewElement(cbox, element424);

        Element element431 = new Element();
        element431.setOid("1.3.6.1.4.1.17484.2.7.2.1.7.1");
        element431.setName("Ping DcSw1 Value1");
        element431.setUsability(true);
        element431.setRewritable(true);
        addNewElement(cbox, element431);

        Element element432 = new Element();
        element432.setOid("1.3.6.1.4.1.17484.2.7.2.1.7.2");
        element432.setName("Ping DcSw1 Value2");
        element432.setUsability(true);
        element432.setRewritable(true);
        addNewElement(cbox, element432);

        Element element433 = new Element();
        element433.setOid("1.3.6.1.4.1.17484.2.7.2.1.7.3");
        element433.setName("Ping DcSw1 Value3");
        element433.setUsability(true);
        element433.setRewritable(true);
        addNewElement(cbox, element433);

        Element element434 = new Element();
        element434.setOid("1.3.6.1.4.1.17484.2.7.2.1.7.4");
        element434.setName("Ping DcSw1 Value4");
        element434.setUsability(true);
        element434.setRewritable(true);
        addNewElement(cbox, element434);

        Element element441 = new Element();
        element441.setOid("1.3.6.1.4.1.17484.2.7.2.1.8.1");
        element441.setName("Ping DcSw2 Action1");
        element441.setUsability(true);
        element441.setRewritable(true);
        addNewElement(cbox, element441);

        Element element442 = new Element();
        element442.setOid("1.3.6.1.4.1.17484.2.7.2.1.8.2");
        element442.setName("Ping DcSw2 Action2");
        element442.setUsability(true);
        element442.setRewritable(true);
        addNewElement(cbox, element442);

        Element element443 = new Element();
        element443.setOid("1.3.6.1.4.1.17484.2.7.2.1.8.3");
        element443.setName("Ping DcSw2 Action3");
        element443.setUsability(true);
        element443.setRewritable(true);
        addNewElement(cbox, element443);

        Element element444 = new Element();
        element444.setOid("1.3.6.1.4.1.17484.2.7.2.1.8.4");
        element444.setName("Ping DcSw2 Action4");
        element444.setUsability(true);
        element444.setRewritable(true);
        addNewElement(cbox, element444);

        Element element451 = new Element();
        element451.setOid("1.3.6.1.4.1.17484.2.7.2.1.9.1");
        element451.setName("Ping DcSw2 Value1");
        element451.setUsability(true);
        element451.setRewritable(true);
        addNewElement(cbox, element451);

        Element element452 = new Element();
        element452.setOid("1.3.6.1.4.1.17484.2.7.2.1.9.2");
        element452.setName("Ping DcSw2 Value2");
        element452.setUsability(true);
        element452.setRewritable(true);
        addNewElement(cbox, element452);

        Element element453 = new Element();
        element453.setOid("1.3.6.1.4.1.17484.2.7.2.1.9.3");
        element453.setName("Ping DcSw2 Value3");
        element453.setUsability(true);
        element453.setRewritable(true);
        addNewElement(cbox, element453);

        Element element454 = new Element();
        element454.setOid("1.3.6.1.4.1.17484.2.7.2.1.9.4");
        element454.setName("Ping DcSw2 Value4");
        element454.setUsability(true);
        element454.setRewritable(true);
        addNewElement(cbox, element454);

        Element element461 = new Element();
        element461.setOid("1.3.6.1.4.1.17484.2.7.2.1.10.1");
        element461.setName("Ping DcSw3 Action1");
        element461.setUsability(true);
        element461.setRewritable(true);
        addNewElement(cbox, element461);

        Element element462 = new Element();
        element462.setOid("1.3.6.1.4.1.17484.2.7.2.1.10.2");
        element462.setName("Ping DcSw3 Action2");
        element462.setUsability(true);
        element462.setRewritable(true);
        addNewElement(cbox, element462);

        Element element463 = new Element();
        element463.setOid("1.3.6.1.4.1.17484.2.7.2.1.10.3");
        element463.setName("Ping DcSw3 Action3");
        element463.setUsability(true);
        element463.setRewritable(true);
        addNewElement(cbox, element463);

        Element element464 = new Element();
        element464.setOid("1.3.6.1.4.1.17484.2.7.2.1.10.4");
        element464.setName("Ping DcSw3 Action4");
        element464.setUsability(true);
        element464.setRewritable(true);
        addNewElement(cbox, element464);

        Element element471 = new Element();
        element471.setOid("1.3.6.1.4.1.17484.2.7.2.1.11.1");
        element471.setName("Ping DcSw3 Value1");
        element471.setUsability(true);
        element471.setRewritable(true);
        addNewElement(cbox, element471);

        Element element472 = new Element();
        element472.setOid("1.3.6.1.4.1.17484.2.7.2.1.11.2");
        element472.setName("Ping DcSw3 Value2");
        element472.setUsability(true);
        element472.setRewritable(true);
        addNewElement(cbox, element472);

        Element element473 = new Element();
        element473.setOid("1.3.6.1.4.1.17484.2.7.2.1.11.3");
        element473.setName("Ping DcSw3 Value3");
        element473.setUsability(true);
        element473.setRewritable(true);
        addNewElement(cbox, element473);

        Element element474 = new Element();
        element474.setOid("1.3.6.1.4.1.17484.2.7.2.1.11.4");
        element474.setName("Ping DcSw3 Value4");
        element474.setUsability(true);
        element474.setRewritable(true);
        addNewElement(cbox, element474);

        Element element481 = new Element();
        element481.setOid("1.3.6.1.4.1.17484.2.7.2.1.12.1");
        element481.setName("Ping AcSw Action1");
        element481.setUsability(true);
        element481.setRewritable(true);
        addNewElement(cbox, element481);

        Element element482 = new Element();
        element482.setOid("1.3.6.1.4.1.17484.2.7.2.1.12.2");
        element482.setName("Ping AcSw Action2");
        element482.setUsability(true);
        element482.setRewritable(true);
        addNewElement(cbox, element482);

        Element element483 = new Element();
        element483.setOid("1.3.6.1.4.1.17484.2.7.2.1.12.3");
        element483.setName("Ping AcSw Action3");
        element483.setUsability(true);
        element483.setRewritable(true);
        addNewElement(cbox, element483);

        Element element484 = new Element();
        element484.setOid("1.3.6.1.4.1.17484.2.7.2.1.12.4");
        element484.setName("Ping AcSw Action4");
        element484.setUsability(true);
        element484.setRewritable(true);
        addNewElement(cbox, element484);

        Element element491 = new Element();
        element491.setOid("1.3.6.1.4.1.17484.2.7.2.1.13.1");
        element491.setName("Ping AcSw Value1");
        element491.setUsability(true);
        element491.setRewritable(true);
        addNewElement(cbox, element491);

        Element element492 = new Element();
        element492.setOid("1.3.6.1.4.1.17484.2.7.2.1.13.2");
        element492.setName("Ping AcSw Value2");
        element492.setUsability(true);
        element492.setRewritable(true);
        addNewElement(cbox, element492);

        Element element493 = new Element();
        element493.setOid("1.3.6.1.4.1.17484.2.7.2.1.13.3");
        element493.setName("Ping AcSw Value3");
        element493.setUsability(true);
        element493.setRewritable(true);
        addNewElement(cbox, element493);

        Element element494 = new Element();
        element494.setOid("1.3.6.1.4.1.17484.2.7.2.1.13.4");
        element494.setName("Ping AcSw Value4");
        element494.setUsability(true);
        element494.setRewritable(true);
        addNewElement(cbox, element494);

        Element element501 = new Element();
        element501.setOid("1.3.6.1.4.1.17484.2.7.2.1.14.1");
        element501.setName("PingTrapFlag1");
        element501.setUsability(true);
        element501.setRewritable(true);
        addNewElement(cbox, element501);

        Element element502 = new Element();
        element502.setOid("1.3.6.1.4.1.17484.2.7.2.1.14.2");
        element502.setName("PingTrapFlag2");
        element502.setUsability(true);
        element502.setRewritable(true);
        addNewElement(cbox, element502);

        Element element503 = new Element();
        element503.setOid("1.3.6.1.4.1.17484.2.7.2.1.14.3");
        element503.setName("PingTrapFlag3");
        element503.setUsability(true);
        element503.setRewritable(true);
        addNewElement(cbox, element503);

        Element element504 = new Element();
        element504.setOid("1.3.6.1.4.1.17484.2.7.2.1.14.4");
        element504.setName("PingTrapFlag4");
        element504.setUsability(true);
        element504.setRewritable(true);
        addNewElement(cbox, element504);

        Element element511 = new Element();
        element511.setOid("1.3.6.1.4.1.17484.2.7.2.1.15.1");
        element511.setName("Ping TimeOut Variable1");
        element511.setUsability(true);
        element511.setRewritable(true);
        addNewElement(cbox, element511);

        Element element512 = new Element();
        element512.setOid("1.3.6.1.4.1.17484.2.7.2.1.15.2");
        element512.setName("Ping TimeOut Variable2");
        element512.setUsability(true);
        element512.setRewritable(true);
        addNewElement(cbox, element512);

        Element element513 = new Element();
        element513.setOid("1.3.6.1.4.1.17484.2.7.2.1.15.3");
        element513.setName("Ping TimeOut Variable3");
        element513.setUsability(true);
        element513.setRewritable(true);
        addNewElement(cbox, element513);

        Element element514 = new Element();
        element514.setOid("1.3.6.1.4.1.17484.2.7.2.1.15.4");
        element514.setName("Ping TimeOut Variable4");
        element514.setUsability(true);
        element514.setRewritable(true);
        addNewElement(cbox, element514);

        Element element521 = new Element();
        element521.setOid("1.3.6.1.4.1.17484.2.8.2.1.1.1");
        element521.setName("ADC Value1");
        element521.setUsability(true);
        element521.setRewritable(false);
        addNewElement(cbox, element521);

        Element element522 = new Element();
        element522.setOid("1.3.6.1.4.1.17484.2.8.2.1.1.2");
        element522.setName("ADC Value2");
        element522.setUsability(true);
        element522.setRewritable(false);
        addNewElement(cbox, element522);

        Element element523 = new Element();
        element523.setOid("1.3.6.1.4.1.17484.2.8.2.1.1.3");
        element523.setName("ADC Value3");
        element523.setUsability(true);
        element523.setRewritable(false);
        addNewElement(cbox, element523);

        Element element524 = new Element();
        element524.setOid("1.3.6.1.4.1.17484.2.8.2.1.1.4");
        element524.setName("ADC Value4");
        element524.setUsability(true);
        element524.setRewritable(false);
        addNewElement(cbox, element524);

        Element element525 = new Element();
        element525.setOid("1.3.6.1.4.1.17484.2.8.2.1.1.5");
        element525.setName("ADC Value5");
        element525.setUsability(true);
        element525.setRewritable(false);
        addNewElement(cbox, element525);

        Element element526 = new Element();
        element526.setOid("1.3.6.1.4.1.17484.2.8.2.1.1.6");
        element526.setName("ADC Value6");
        element526.setUsability(true);
        element526.setRewritable(false);
        addNewElement(cbox, element526);

        Element element527 = new Element();
        element527.setOid("1.3.6.1.4.1.17484.2.8.2.1.1.7");
        element527.setName("ADC Value7");
        element527.setUsability(true);
        element527.setRewritable(false);
        addNewElement(cbox, element527);

        Element element528 = new Element();
        element528.setOid("1.3.6.1.4.1.17484.2.8.2.1.1.8");
        element528.setName("ADC Value8");
        element528.setUsability(true);
        element528.setRewritable(false);
        addNewElement(cbox, element528);

        Element element531 = new Element();
        element531.setOid("1.3.6.1.4.1.17484.2.8.2.1.2.1");
        element531.setName("ADCThresholdLevel1");
        element531.setUsability(true);
        element531.setRewritable(true);
        addNewElement(cbox, element531);

        Element element532 = new Element();
        element532.setOid("1.3.6.1.4.1.17484.2.8.2.1.2.2");
        element532.setName("ADCThresholdLevel2");
        element532.setUsability(true);
        element532.setRewritable(true);
        addNewElement(cbox, element532);

        Element element533 = new Element();
        element533.setOid("1.3.6.1.4.1.17484.2.8.2.1.2.3");
        element533.setName("ADCThresholdLevel3");
        element533.setUsability(true);
        element533.setRewritable(true);
        addNewElement(cbox, element533);

        Element element534 = new Element();
        element534.setOid("1.3.6.1.4.1.17484.2.8.2.1.2.4");
        element534.setName("ADCThresholdLevel4");
        element534.setUsability(true);
        element534.setRewritable(true);
        addNewElement(cbox, element534);

        Element element535 = new Element();
        element535.setOid("1.3.6.1.4.1.17484.2.8.2.1.2.5");
        element535.setName("ADCThresholdLevel5");
        element535.setUsability(true);
        element535.setRewritable(true);
        addNewElement(cbox, element535);

        Element element536 = new Element();
        element536.setOid("1.3.6.1.4.1.17484.2.8.2.1.2.6");
        element536.setName("ADCThresholdLevel6");
        element536.setUsability(true);
        element536.setRewritable(true);
        addNewElement(cbox, element536);

        Element element537 = new Element();
        element537.setOid("1.3.6.1.4.1.17484.2.8.2.1.2.7");
        element537.setName("ADCThresholdLevel7");
        element537.setUsability(true);
        element537.setRewritable(true);
        addNewElement(cbox, element537);

        Element element538 = new Element();
        element538.setOid("1.3.6.1.4.1.17484.2.8.2.1.2.8");
        element538.setName("ADCThresholdLevel8");
        element538.setUsability(true);
        element538.setRewritable(true);
        addNewElement(cbox, element538);

        Element element541 = new Element();
        element541.setOid("1.3.6.1.4.1.17484.2.8.2.1.3.1");
        element541.setName("PingTrapFlag1");
        element541.setUsability(true);
        element541.setRewritable(true);
        addNewElement(cbox, element541);

        Element element542 = new Element();
        element542.setOid("1.3.6.1.4.1.17484.2.8.2.1.3.2");
        element542.setName("PingTrapFlag2");
        element542.setUsability(true);
        element542.setRewritable(true);
        addNewElement(cbox, element542);

        Element element543 = new Element();
        element543.setOid("1.3.6.1.4.1.17484.2.8.2.1.3.3");
        element543.setName("PingTrapFlag3");
        element543.setUsability(true);
        element543.setRewritable(true);
        addNewElement(cbox, element543);

        Element element544 = new Element();
        element544.setOid("1.3.6.1.4.1.17484.2.8.2.1.3.4");
        element544.setName("PingTrapFlag4");
        element544.setUsability(true);
        element544.setRewritable(true);
        addNewElement(cbox, element544);

        Element element545 = new Element();
        element545.setOid("1.3.6.1.4.1.17484.2.8.2.1.3.5");
        element545.setName("PingTrapFlag5");
        element545.setUsability(true);
        element545.setRewritable(true);
        addNewElement(cbox, element545);

        Element element546 = new Element();
        element546.setOid("1.3.6.1.4.1.17484.2.8.2.1.3.6");
        element546.setName("PingTrapFlag6");
        element546.setUsability(true);
        element546.setRewritable(true);
        addNewElement(cbox, element546);

        Element element547 = new Element();
        element547.setOid("1.3.6.1.4.1.17484.2.8.2.1.3.7");
        element547.setName("PingTrapFlag7");
        element547.setUsability(true);
        element547.setRewritable(true);
        addNewElement(cbox, element547);

        Element element548 = new Element();
        element548.setOid("1.3.6.1.4.1.17484.2.8.2.1.3.8");
        element548.setName("PingTrapFlag8");
        element548.setUsability(true);
        element548.setRewritable(true);
        addNewElement(cbox, element548);

        return cbox;
    }
}
