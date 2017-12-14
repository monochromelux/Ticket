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
public class parkInfoParsing extends Thread {
     // 다운로드 받은 문자열을 저장할 변수
    private String xml;
    // 파싱한 결과를 저장할 리스트 - 몇개인지 모르므로 배열이 아니고 ArrayList로 만들어야 합니다.
    List<String> data = new ArrayList<>();
    StringBuilder buf = new StringBuilder();
    
    public void pas() {
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
            NodeList list0 = element.getElementsByTagName("jibunAddr");
            StringBuilder content = new StringBuilder();
            content.append("지번주소 : ");
            // 리스트를 순회하면서 데이터를 data에 추가
            for (int i = 0; i < list0.getLength(); i++) {
                // i번째 tmx 태그를 node에 저장
                Node node = list0.item(i);
                // 태그 내의 첫번째 값 앞으로 이동
                Node temp = node.getFirstChild();
                // 태그 내의 첫번째 값을 value에 저장
                content.append(temp.getNodeValue());
            }
            // 값을 data에 저장
            data.add(content.toString());
            
            NodeList list1  = element.getElementsByTagName("parkHyung");
            StringBuilder plus1 = new StringBuilder();
            plus1.append("주차장 형태 : ");

            for (int i = 0; i < list1.getLength(); i++) {
            // i번째 tmx 태그를 node에 저장
            Node node = list1.item(i);
            // 태그 내의 첫번째 값 앞으로 이동
            Node temp = node.getFirstChild();
            // 태그 내의 첫번째 값을 value에 저장
            plus1.append(temp.getNodeValue());
            }
            // 값을 data에 저장
            data.add(plus1.toString());

            NodeList list2  = element.getElementsByTagName("workTime");
            StringBuilder plus2 = new StringBuilder();
            plus2.append("운영 시간 : ");

            for (int i = 0; i < list2.getLength(); i++) {
            // i번째 tmx 태그를 node에 저장
            Node node = list2.item(i);
            // 태그 내의 첫번째 값 앞으로 이동
            Node temp = node.getFirstChild();
            // 태그 내의 첫번째 값을 value에 저장
            plus2.append(temp.getNodeValue());
            }
            // 값을 data에 저장
            data.add(plus2.toString());

            NodeList list3  = element.getElementsByTagName("allday");
            StringBuilder plus3 = new StringBuilder();
            plus3.append("1일 가격 : ");

            for (int i = 0; i < list3.getLength(); i++) {
            // i번째 tmx 태그를 node에 저장
            Node node = list3.item(i);
            // 태그 내의 첫번째 값 앞으로 이동
            Node temp = node.getFirstChild();
            // 태그 내의 첫번째 값을 value에 저장
            plus3.append(temp.getNodeValue());
            }
            // 값을 data에 저장
            data.add(plus3.toString());
            plus3.append("원");
            
            NodeList list4  = element.getElementsByTagName("chuTen");
            StringBuilder plus4 = new StringBuilder();
            plus4.append("기본요금(10분마다) : ");

            for (int i = 0; i < list4.getLength(); i++) {
            // i번째 tmx 태그를 node에 저장
            Node node = list4.item(i);
            // 태그 내의 첫번째 값 앞으로 이동
            Node temp = node.getFirstChild();
            // 태그 내의 첫번째 값을 value에 저장
            plus4.append(temp.getNodeValue());
            }
            // 값을 data에 저장
            data.add(plus4.toString());
            plus4.append("원");
            
            NodeList list5  = element.getElementsByTagName("telno");
            StringBuilder plus5 = new StringBuilder();
            plus4.append("문의전화 : ");

            for (int i = 0; i < list5.getLength(); i++) {
            // i번째 tmx 태그를 node에 저장
            Node node = list5.item(i);
            // 태그 내의 첫번째 값 앞으로 이동
            Node temp = node.getFirstChild();
            // 태그 내의 첫번째 값을 value에 저장
            plus5.append(temp.getNodeValue());
            }
            // 값을 data에 저장
            data.add(plus5.toString());
 
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("파싱에러" + e.getMessage());
        }
    }
 
    public void run(String listcode, String Concode) {
        try {
            // 연결+옵션설정
            StringBuilder urlBuilder = new StringBuilder("http://opendata.busan.go.kr/openapi/service/PublicParkingLotService/getPublicParkingLotDetail"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=cfE3OE4wYLd18HtkeiGwTFizn3o7cLr%2BTi%2FaXInsfm788hpvacwd1QE4lDRqWPRwasxezCd%2FZ0Mv8td7QC826A%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /**/
            //urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /**/
            urlBuilder.append("&" + URLEncoder.encode("gu","UTF-8") + "=" + URLEncoder.encode(listcode, "UTF-8")); /**/
            urlBuilder.append("&" + URLEncoder.encode("parkno","UTF-8") + "=" + URLEncoder.encode(Concode, "UTF-8")); /**/
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
        pas();
 
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
