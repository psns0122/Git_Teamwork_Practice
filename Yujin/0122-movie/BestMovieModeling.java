package day11;

import java.util.Scanner;

public class BestMovieModeling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  //3  //키보드 입력 받는다
        System.out.print("입력할 영화의 총개수를 입력하세요 :");  //5
        int movieTotal = input.nextInt();  //4        // 영화 개수 입력 받는다
        System.out.print("각 영화당 상세정보의 개수를 입력하세요"); //6
        int movieInfo = input.nextInt(); //7         //영화 상세정보 입력 받는다
        input.nextLine();  //버퍼 비우기
        /*
        //레벨업 : 5개의 영화를 배열로 관리하고 싶다. movieArray 를 만들어 5개의 영화정보를 입력한 후 해당 전체 영화리스트를 출력
        MovieVO[][] movieArray; //1
        movieArray = new MovieVO[movieTotal][movieInfo];  //5개 영화,6개의 정보의 데이터구조 배열 //2
        //3개의 영화의 상세정보목록의 개수는 3개(title, actor, grade)
        //정보를 입력받고 해당 영화정보의 내용이 자동으로 movieArray에 할당되도록 만들어주세요
        */

        MovieVO[] movieArray = new MovieVO[movieTotal]; // 무비 배열의 공간 생성

        //입력
        for(int i=0;i<movieTotal;i++){
            movieArray[i]=new MovieVO();  //i번째에 무비 객체 생성

            System.out.print("제목: ");
            movieArray[i].setTitle(input.nextLine());  //i번째 제목 입력

            System.out.print("개봉일: ");
            movieArray[i].setOpenDay(input.nextLine()); //i번째 개봉일 입력

            System.out.print("배우: ");
            movieArray[i].setActor(input.nextLine());  //i번째 배우이름 입력

            System.out.print("런닝타임(분): ");
            movieArray[i].setRunningtime(input.nextLine());  //i번째 런닝타임 입력

            System.out.print("장르: ");
            movieArray[i].setGenre(input.nextLine());    //i번째 장르 입력

            System.out.print("등급 :");
            movieArray[i].setGrade(input.nextLine());      //i번째 등급 입력
        }

        //출력
        for(int i=0;i<movieTotal;i++){
            System.out.println("제목 :"+movieArray[i].getTitle());
            System.out.println("개봉일: "+movieArray[i].getOpenDay());
            System.out.println("배우: "+movieArray[i].getActor());
            System.out.println("런닝타임(분): "+movieArray[i].getRunningtime());
            System.out.println("장르: "+movieArray[i].getGenre());
            System.out.println("등급 :"+movieArray[i].getGrade());
        }

/*
        MovieVO avatar = new MovieVO();
        System.out.println(avatar.toString());
        avatar.setOpenDay("2022.12.14");
        avatar.setActor("제이크 설리");
        avatar.setRunningtime("192");

        System.out.println("+++++++" + avatar.getTitle() + "영화정보 +++++++");
        System.out.printf("제목 : %s %n ", avatar.getTitle());
        System.out.printf("배우 : %s %n ", avatar.getActor());
        System.out.printf("런닝타임 : %s %n ", avatar.getRunningtime());
        System.out.printf("등급 : %s %n ", avatar.getGrade());
        System.out.println("++++++++++++++++++++++++++");

 */

    }
}
