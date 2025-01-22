# GIT 명령어 정리

## [복사/붙여넣기 단축키]
**단순 블럭잡기** : 복사
**Shift+Insert** : 붙여넣기

## [리눅스 명령어]
**mkdir a** : a라는 폴더를 새로 만든다 (메이크 디렉토리)
**cd a** : a라는 폴더의 내부로 내가 있는 경로를 이동한다 (체인지 디렉토리)

**ls** : 현재 경로의 내부를 본다 (/ 붙은건 디렉토리)
**ls -a** : 숨김파일까지 포함해서 본다

**history** : 지금까지 사용한 명령어 기록 
**rm -rf .git** : 깃 제거하기

**A && B** : A 명령어 이후 B 명령어 실행 (ex. touch c.txt && git add .)

## [리눅스에서 파일을 만드는 방법]
**touch a.txt** : a.txt 파일 생성

**echo "출력할 문자열"** : 커멘드 창에 문자열 그대로 출력됨
	-> echo "파일에 입력할 문자열" > README.md : 파일 생성과 동시에 파일에 문자열 덮어쓰기 (파일입출력 w 타입)
	-> echo "파일에 입력할 문자열" >> README.md : 파일 생성과 동시에 파일에 문자열 이어쓰기 (파일입출력 a 타입)
    
**vi 파일명** : vi 편집기로 만드는 방법 (사용방법 위 vi편집기와 동일)
	-> cat, head, tail 명령어로 내부 확인 가능

---

## [git 명령어]

### 1. 로컬 저장소 생성, 관리

**git init** : 현재 경로에서 깃 사용 시작
**git status** : 현재 경로의 파일 변경사항 확인 / 상태 확인
**git add** : 변경사항이 있는 파일을 로컬 저장소에 임시 저장 (git add . / git add *)
**git rm --c a.txt** : 로컬 저장소에 임시저장된 파일 캐시 지우기 / 트래킹 취소하기 (리무브 캐시)
**git reset** : 로컬 저장소에 임시저장된 모든 파일의 캐시를 지움 / 트래킹 취소하기 (리무브 캐시)

### 2. 자격증명 관리 (git config)

**git config --global user.email "깃허브 메일주소"
git config --global user.name "깃허브 유저네임"**
-> 깃 전역 설정, 이 컴퓨터에서 깃을 사용하면 항상 이 유저가 작성한걸로 알겠다
-> if) 자격증명이 많다면 : --local 명령어를 사용

**git config --global -l** : 자격증명 확인하기
**git config --global --unset user.email** : user.email 속성(변수) 제거

### 3. 로컬 저장소 변경사항 확정 (git commit)

**git commit** : vi 편집기 실행
-> 편집모드 들어가기 : i / 저장하기 : esc+:wq (write and quit, 강제 필요할 경우 !)
-> 명령모드 들어가기 : esc+: / 나가기 : esc+:q (강제탈출 : !q, q!)
-> 명령모드에서 dd 누르면 해당 줄 삭제
**git commit -m "커밋명"** : vi 편집기를 실행하지 않고 커밋 메세지 입력, 로컬 브렌치로 업로드됨

### 4. 로컬 저장소 커밋 기록 확인 (git log)

**git log** : 해시코드, 작성자, 작성일, 작성위치(브랜치), 커밋 메세지를 확인
**git log --oneline** : 깃 로그를 짧게 보는 방법
**git log --all** : 브랜치 변경 후에도 전체 로그 확인하는 방법
**git log --oneline --graph --all** : 브랜치 그래프 시각화

**git reset HEAD~1** : 커밋 취소 현재 위치한 곳에서 한단계 전으로 이동 (HEAD가 현재 커밋 위치)
-> (\*중요*) add 직전 상태로 되돌리는 것, git status를 다시 해보면 빨간글씨로 c.txt 보임

### 5. 로컬 저장소 커밋 기록 수정 (git commit --amend)

**git commit --amend** : vi 편집기 오픈
**git commit --amend -m "변경할 커밋명"** : 직전 커밋 메세지 수정
**git commit --amend -date "변경할 날짜" --no-edit** : 현재 시간 기준 1년 전으로 커밋 시점 변경

### 6. 원격 저장소(GitHub)를 로컬 저장소에 연결 (git remote)

**git remote add origin 깃 경로** : 새로운 원격저장소를 origin이라는 별칭으로 연결
-> 원격저장소는 여러개를 둘 수 있음 (사본 개념) / 일반적으로는 효율적인 관리를 위해 단일화

**git remote -v** : 현재 연결된 원격저장소 목록 확인
```
// 결과 예시
origin  https://github.com/psns0122/repo.git (fetch)
origin  https://github.com/psns0122/repo.git (push)
```
**git remote remove origin** : 원격저장소 삭제
**git remote set-url origin** : 원격저장소 경로 수정

### 7. 원격 저장소(GitHub)로 로컬 저장소 데이터 업로드 하기 (git push)

**git branch -M main** : 현재 브랜치(대표 브랜치)를 main으로 수정
**git push -u origin main** : main 브랜치를 origin이라는 이름의 원격저장소로 전송 (-u 지정시 앞으로 origin main 생략 가능)

### 8. 원격 저장소(GitHub)에서 로컬 저장소로 데이터 가져오기 (git fetch, pull, clone)

**git fetch** : 원격저장소에서 변경된 사항에 대한 정보만 읽어오기
**git pull origin main** : 원격저장소의 main 브랜치를 현재 경로로 끌어옴 (동기화 작업)

**git clone 깃 주소** : 리포지토리가 가지고 있는 모든 히스토리(겸 데이터)를 가져오는 명령어 (git init은 처음부터 시작)
-> 커밋의 해시코드까지 동일하게 가져옴
**git clone 깃 주소 원하는 폴더명** : 깃 주소의 뒤에 원하는 폴더명을 직접 입력하여 폴더를 생성

---

## [branch - 공간을 구분하는 역할]
* HEAD : 현재 내가 위치한 브랜치를 가리키는 포인터
  \* 브랜치 전환 전에 지금까지의 변화 내역이 모두 커밋 되어야 한다.
  \* 커밋되지 않으면 지금가지의 변화 내용이 내가 전환하는 브랜치로 따라서 이동된다.  

**git branch** : 브랜치 목록 확인
**git branch feature** : feature라는 이름의 독립된 브랜치 생성 (feature == 기능이라는 뜻)

**git checkout master** : master 브랜치로 이동 (권장하지 않음, 옛날 방식)
**git switch feature** : feature 브랜치로 이동
**git switch -c dev** : dev 브랜치를 생성하면서 동시에 dev로 이동

* git branch 이름 예시
  * **git branch featuer** : 새로운 기능 개발을 위한 브랜치
  * **git branch hotfix** : 빠른 수정을 위한 브랜치
  * **git branch release** : 배포를 위한 브랜치

**git branch -d feature**
-> 병합하지 않으면 error 발생 : 강제삭제를 위해 -D 사용 (git branch -D feature)
-> 병합하면 error 없이 실행

## [merge - 브랜치(branch) 병합]

**git merge 다른 브랜치명** : 현재 브랜치에 다른 브랜치를 병합

* 병합시 다음 세가지 상황 발생
  1. **Fast-Forward**: 한 쪽만 앞서나가서 발전한 경우, 즉 합쳐도 이상이 없을 때 Fast-Forward(빨리감기)가 발동 (같은 파일에 같은 내용이 있다가 추가 내용이 있는 경우)
  2. **3-Way Merge** : 각기 다른 발전 방향이 있을 때 : 제 3의 커밋이 발생 (ex. Merge branch 'dev')
  3. **Merge Conflict** : 서로 동일한 개발을 진행했을 때 (ex. 둘다 마라탕을 만들었는데 레시피가 달라) : 수동 해결 필요 (같은 파일에 서로 다른 내용이 있어서 충돌이 발생하는 경우)

* Merge Conflict 가 발생해서 수동 해결이 필요한 경우
  * 아래 3개 중 하나의 방침을 선택해서 직접 수정
    1. 나를 택한다 (HEAD)
    2. hotfix를 택한다 (merge 대상)
    3. 둘다 택한다  
* 충돌 발생시 예시 상황
```
cat mrt.txt
<<<<<<< HEAD
줌
로션
치과
<null>=======
티라미숙해
제로콜라
연근 감자 청경채
<null>>>>>>>> hotfix
```

-> 충돌 해결하고
-> git add .
-> git commit
-> vi 편집기에서 나오기

#### * merge 와 리베이스의 차이점
<null>- 리베이스를 하면 복잡한 브랜치 그래프를 정리할 수 있다

## [Forking Workflow - 포킹]
\- 여러개의 저장소를 두고 각자 관리 (branch는 논리적 공간 분리, fork는 물리적 공간 분리)
\- 원격에 있는걸 원격으로 카피 -> 이후 원본에 Pull Request를 요청해서 원본에 병합하기 가능
\- 원본은 요청에 대해 리뷰하고 원본에 병합할지 말지 결정 -> Merge pull request

- ex) 팀플하면서 새로운 단체계정의 리포지토리를 생성했을 때
  -> 해당 리포지토리를 내 계정으로 포크
  -> 내 계정에서 수정 진행하다가 변경사항에 대해 원본으로 Pull Request 요청
  -> 원본 담당하는 팀원이 요청에 대해 리뷰하고 -> Merge Pull request 선택

## [.gitignore - 무시할 파일/폴더 설정]
1. 정확하게 무시하고자 하는 파일명을 작성
2. *.확장자명 : 동일한 확장자에 대한 무시 권한 설정
3. 폴더명/ : 해당 폴더 안에 있는 폴더를 아예 무시
- gitignore 패턴 설정 사이트 : https://www.toptal.com/developers/gitignore

---
  
## [마크다운 문법]

**\#** : 1~6개까지 사용 가능, 제목을 설정
  
**\*\*\*, ---, \_\_\_** : (단독사용시) 수평선
**<<null>br>, 띄어쓰기 두개** : 줄바꿈
  
**\*\*, __** : 굵게
**\*** : 기울게
**\~\~** : 취소선
**\*\*\*** : 굵고 기울게
**<<null>u>** : 밑줄
  
**\>** : 1~4개까지 사용 가능, 인용
**\*, \-, \+** : 순서가 없는 목록
**123** : 순서가 있는 목록
  
**\`** : \`로 묶었을 때, 한줄 코드
**\```** : \```로 묶었을 때, 여러줄 코드 (\``` java 이렇게 어떤 언어인지 알려주면 코드블럭의 컬러셋을 해당 언어로 설정해줄 수 있다)
  
**\[텍스트](링크)** : 텍스트 링크 표시
**![이미지 설명](이미지 주소)** : 이미지 표시
**\[![이미지 설명](이미지 주소)](링크)** : 이미지에 링크 걸기
  
**테이블 그리기** : https://www.tablesgenerator.com/markdown_tables 

## [github .dev - 온라인 편집기]
1. 접속방법 : 온라인 github 리포지토리에 접속한 상태에서 . 을 타이핑하면 접속
2. 리포지토리로 돌아가는 방법 : 햄버거 버튼 -> 리포지토리로 이동 선택