/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ggrr1
 */
public class InfoParsing extends Thread {
    // 다운로드 받은 문자열을 저장할 변수
    private String xml;
    // 파싱한 결과를 저장할 리스트 - 몇개인지 모르므로 배열이 아니고 ArrayList로 만들어야 합니다.
    List<String> data = new ArrayList<>();
    StringBuilder buf = new StringBuilder();
    
    public void pas(String Infocode) {
        try {
            // 자신의 static 메서드를 가지고 객체를 생성 : 싱글톤 패턴
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // 다른 클래스의 객체를 가지고, 객체를 생성하면 팩토리 패턴.
            DocumentBuilder documentbuilder = factory.newDocumentBuilder(); //// 팩토리 메서드 패턴  공장에서 찍어줌
            // 문자열을 InputStream으로 변환
            InputStream is = new ByteArrayInputStream(xml.getBytes());
            Document doc = documentbuilder.parse(is);
            // xml을 메모리에 펼쳐놓고 루트를 elemnt에 저장
            Element element = doc.getDocumentElement();
 
            // 파싱할 태그의 리스트를 찾아온다
            // tmx 태그 전체를 list에 저장
            NodeList list = element.getElementsByTagName("dataContent");
            StringBuilder content = new StringBuilder();
            // 리스트를 순회하면서 데이터를 data에 추가
            for (int i = 0; i < list.getLength(); i++) {
                // i번째 tmx 태그를 node에 저장
                Node node = list.item(i);
                // 태그 내의 첫번째 값 앞으로 이동
                Node temp = node.getFirstChild();
                // 태그 내의 첫번째 값을 value에 저장
                content.append(temp.getNodeValue());
                content.append("\n");
            }
            // 값을 data에 저장
            data.add(content.toString());
            
            if(Infocode != "4" || Infocode != "5" || Infocode != "6") {
                NodeList place  = element.getElementsByTagName("place");
                StringBuilder plus = new StringBuilder();
                plus.append("장소 : ");
                
                for (int i = 0; i < place.getLength(); i++) {
                // i번째 tmx 태그를 node에 저장
                Node node = place.item(i);
                // 태그 내의 첫번째 값 앞으로 이동
                Node temp = node.getFirstChild();
                // 태그 내의 첫번째 값을 value에 저장
                plus.append(temp.getNodeValue());
                }
                // 값을 data에 저장
                data.add(plus.toString());
            }
             if(Infocode != "4" || Infocode != "5" || Infocode != "6") {
                NodeList place  = element.getElementsByTagName("time");
                StringBuilder plus = new StringBuilder();
                plus.append("시간 : ");
                
                for (int i = 0; i < place.getLength(); i++) {
                // i번째 tmx 태그를 node에 저장
                Node node = place.item(i);
                // 태그 내의 첫번째 값 앞으로 이동
                Node temp = node.getFirstChild();
                // 태그 내의 첫번째 값을 value에 저장
                plus.append(temp.getNodeValue());
                }
                // 값을 data에 저장
                data.add(plus.toString());
            }
            if(element.getElementsByTagName("useperiod") != null) {
                NodeList place  = element.getElementsByTagName("useperiod");
                StringBuilder plus = new StringBuilder();
                plus.append("가격 : ");
                
                for (int i = 0; i < place.getLength(); i++) {
                // i번째 tmx 태그를 node에 저장
                Node node = place.item(i);
                // 태그 내의 첫번째 값 앞으로 이동
                Node temp = node.getFirstChild();
                // 태그 내의 첫번째 값을 value에 저장
                plus.append(temp.getNodeValue());
                }
                // 값을 data에 저장
                data.add(plus.toString());
            }
            if(element.getElementsByTagName("tel") != null) {
                NodeList place  = element.getElementsByTagName("tel");
                StringBuilder plus = new StringBuilder();
                plus.append("전화 : ");
                
                for (int i = 0; i < place.getLength(); i++) {
                // i번째 tmx 태그를 node에 저장
                Node node = place.item(i);
                // 태그 내의 첫번째 값 앞으로 이동
                Node temp = node.getFirstChild();
                // 태그 내의 첫번째 값을 value에 저장
                plus.append(temp.getNodeValue());
                }
                // 값을 data에 저장
                data.add(plus.toString());
            }
            if(element.getElementsByTagName("trafin") != null) {
                NodeList place  = element.getElementsByTagName("trafin");
                StringBuilder plus = new StringBuilder();
                plus.append("근처 지하철역 : ");
                
                for (int i = 0; i < place.getLength(); i++) {
                // i번째 tmx 태그를 node에 저장
                Node node = place.item(i);
                // 태그 내의 첫번째 값 앞으로 이동
                Node temp = node.getFirstChild();
                // 태그 내의 첫번째 값을 value에 저장
                plus.append(temp.getNodeValue());
                }
                // 값을 data에 저장
                data.add(plus.toString());
            }
            if(element.getElementsByTagName("userHomepage") != null) {
                NodeList place  = element.getElementsByTagName("userHomepage");
                StringBuilder plus = new StringBuilder();
                plus.append("홈페이지 : ");
                
                for (int i = 0; i < place.getLength(); i++) {
                // i번째 tmx 태그를 node에 저장
                Node node = place.item(i);
                // 태그 내의 첫번째 값 앞으로 이동
                Node temp = node.getFirstChild();
                // 태그 내의 첫번째 값을 value에 저장
                plus.append(temp.getNodeValue());
                }
                // 값을 data에 저장
                data.add(plus.toString());
            }
 
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("파싱에러" + e.getMessage());
        }
    }
 
    public void run(String Infocode, String Concode) {
        //Concode ex:162570
        String pasingcode = null;
        switch(Infocode) {
            case "0":
                pasingcode = "getMusicalDetail"; //연극&뮤지컬 리스트
                break;
            case "1":
                pasingcode = "getExhibitDetail"; //전시&행사 리스트
                break;
            case "2":
                pasingcode = "getMusicDanceDetail"; //음악&무용 리스트
                break;
            case "3":
                pasingcode = "getFestivalDetail"; //축제 리스트
                break;
                
            case "4":
                pasingcode = "getGalleryDetail"; //갤러리 리스트
                break;
            case "5":
                pasingcode = "getExhibitionAreaDetail"; //전시공간 리스트
                break;
            case "6":
                pasingcode = "getTheaterDetail"; //공연장 리스트
                break;
        }
 
        try {
            // 연결+옵션설정
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/CultureInfoService"); /*URL*/
            urlBuilder.append("/" + pasingcode);
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=cfE3OE4wYLd18HtkeiGwTFizn3o7cLr%2BTi%2FaXInsfm788hpvacwd1QE4lDRqWPRwasxezCd%2FZ0Mv8td7QC826A%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("data_sid","UTF-8") + "=" + URLEncoder.encode(Concode, "UTF-8")); /*콘텐츠ID*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setConnectTimeout(10000);
            http.setUseCaches(false);
 
            try ( // 위 부분 까지는 주소만 변경되고 모든 경우 동일
            // 위 주소에서 주는 데이터를 문자열로 읽기 위한 스트림 객체 생성
                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = br.readLine();
                    if (line == null)
                        break;
                    sb.append(line);
                }
                xml = sb.toString();
            }
            http.disconnect();
 
        } catch (IOException e) {
            System.out.println("다운로드에러" + e.getMessage());
 
        }
        // System.out.println(xml);
 
        // 파싱
        pas(Infocode);
        
        // data의 내용을 출력 - 단순 확인만 하는 경우
        // 컬렉션의 toString은 각 데이터의 toString을 다시 호출
        //System.out.println(data);
 
        data.forEach((imsi) -> {
            //System.out.println(imsi);
            buf.append(imsi);
            buf.append("\n");
        });
}
}
