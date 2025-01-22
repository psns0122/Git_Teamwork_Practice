package Day11;

import Day11.vo.MovieVO;

import java.util.Scanner;

public class BestVOModeling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("입력할 영화의 총개수를 입력하세요");
        int movieTotal = input.nextInt();
        System.out.println("각 영화당 상세정보의 개수를 입력하세요");
        int movieInfo = input.nextInt();

        //레벨업: 5개의 영화를 배열로 관리하고 싶음. movieArray를 만들어 5개의 영화정보를 입력한후 해당 전체 영화리스트를 출력
        MovieVO[] movieArray;
        movieArray = new MovieVO[movieTotal];
        //영화를 1차원 movieArray 배열을 생성해서 영화를 관리. movieTotal은 영화의 개수

        //3개 영화의 상세정보목록의 개수는 3개(title, actor, grade)

        //정보를 입력받고 해당 영화정보의 내용이 자동으로 movieArray에 할당되도록 만들어주세요
        //영화 정보 입력 for문을 작성하고 슬랙으로 제출

        for(int i=0;i<movieTotal;i++){
            movieArray[i] = new MovieVO();
            System.out.println("\n[" + (i + 1) + "번째 영화 입력]");
            //int형 배열은 알아서 생성자 생성되나 movie 배열은 생성자 직접 생성해야 함 movieVO 이용해서 생성자 생성
            //for문 이용해서 movieTotal이 3일 경우 i가 0,1,2 3번 반복하게 됨
            
            //movieVO에 있는 각 항목별 데이터를 setter 함수를 통해 출력

            System.out.print("제목: ");
            movieArray[i].setTitle(input.nextLine());

            System.out.print("개봉일: ");
            movieArray[i].setDate(input.nextLine());

            System.out.print("배우: ");
            movieArray[i].setActor(input.nextLine());

            System.out.println("러닝타임(분): ");
            movieArray[i].setRunningTime(input.nextLine());

            System.out.println("장르: ");
            movieArray[i].setRunningTime(input.nextLine());

            System.out.println("등급: ");
            movieArray[i].setGrade(input.nextLine());

        }




        




    }
}

