import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Output {
    void printInfo(URL url, String address) throws URISyntaxException, IOException {
        Information info = new Information();
        System.out.println("도메인 : " + info.getDomain(url));
        System.out.println("스킴 : " + info.getScheme(address));
        System.out.println("경로 : " + info.getPath(url));
        System.out.println("종류 : " + info.getSort(address));
        System.out.println("용량 : " + info.getSize(address));
        System.out.println("대기 시간 : " + info.getWaitingTime());
        System.out.println("다운로드 시간  : " + info.getDownloadTime() + "\n");
    }

    void printResult() {
        System.out.println("=====" + "\n");
        System.out.println("도메인 개수 : ");
        System.out.println("요청 개수 : ");
        System.out.println("이미지(png, gif, jpg) 개수 : ");
        System.out.println("코드(css, js) 개수 : ");
        System.out.println("전송 용량 : ");
        System.out.println("리다이렉트 개수 : ");
        System.out.println("캐시 데이터 개수 : ");
        System.out.println("전체 로딩시간 : " + "\n");
        System.out.println("가장 큰 용량 : ");
        System.out.println("가장 오랜 대기시간 : ");
        System.out.println("가장 오랜 다운로드 시간 : ");
    }
}
