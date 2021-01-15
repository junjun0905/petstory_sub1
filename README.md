# 아이디어

1. Concept : 펫이 직접 일상을 공유하는 Web Site

2. 주제 : 여러가지의 귀여운 애완동물 사진을 공유하는 Social community

3. 페이지구성: 회원가입, 로그인, 마당(게시판),CRUD(짖기,킁킁,다시짖기,깨갱), etc

4. 회원가입 페이지

   이름,나이,키,집주소,취미,이메일

5. 로그인

6. CURD

   -내용 : 그림일기 형식

   ```
    AI:<https://deepai.org/machine-learning-model/toonify>, 
   ```

   - 폰트: https://noonnu.cc/index

7. 코칭

- 패션 자랑하는 공간
- 랭킹 만들어서 스타만드는 기능
- 차별성필요
- 강아지 증명사진,

-집사사진은 반려동물시점으로 뿌옇게

<br>

# Git

- master에서 develop 브랜치 생성
- develop에서 feat 브랜치 생성
- feat 브랜치에서 개발 진행 후 develop에 merge



+ 참고

  + 우아한 형제들 기술 블로그

    https://woowabros.github.io/experience/2017/10/30/baemin-mobile-git-branch-strategy.html

  + ### Git - flow를 사용하게 된 이유

    - 5명의 개발자 전원이 이번 버전에 포함될 기능을 개발하는 건 비효율적

    - 개발 프로세스 변경

      - 기획 - 디자인 - 개발 - QA - 출시 

        =>

      - 이번 버전 필수 작업 + 다음에 언젠가는 배포될 작업 **병렬로** 진행

        <br>

  + ### Git Repo 구성 살펴보기

    - Upstream Remote Repo 

      > 공유용(원격), 최신 소스 코드 저장

    - Origin Remote Repo

      > 개인용(원격), Upstream Repo를 fork

    - Local Repo

      > 개인용(내 컴퓨터)

    - 순서

      - Local에서 작업 --> Origin으로 push

      - Origin --> Upstream으로 MR

      - 코드리뷰 후 Merge

      - Local에서 Upstream Pull 받기

        <br>

  + ### Git-flow 전략

    - 브랜치

      - 항상 유지
        - master : 제품으로 출시될 수 있는 브랜치
        - develop : 다음 출시 버전을 개발하는 브랜치
      - 일정 기간만 유지
        - feature : 기능을 개발하는 브랜치
        - release : 이번 출시 버전을 준비하는 브랜치
        - hotfix : 출시 버전에서 발생한 버그를 수정 하는 브랜치

    - 기능 개발

      - develop에서 feature 브랜치 생성
      - feature에서 개발 후 develop에 Merge

    - QA

      - 모든 기능이 Merge됐다면

        develop에서 release 브랜치 생성

      - release 브랜치에서 버그 수정

      - 모든 버그 수정 후 

        release를 master와 develop에 Merge

        <br>

  + ### Git-flow 이렇게

    1. 티켓 처리

       - 작업 브랜치 생성

       - 작업 브랜치에서 소스코드 수정

       - 작업 브랜치에서 변경 사항 커밋

       - **커밋이 불필요하게 여러개라면, squash**

       - **작업 브랜치를 upstream에 rebase**

         > 브랜치를 최신상태로.

       - 작업 브랜치를 origin에 push

       - github에 PR

       - 코드리뷰 후 merge

    2. develop 변경사항을 feature로 가져오기

       - feature 브랜치에 upstream 브랜치 merge
       - upstream에 변경사항이 merge된 feature를 push

    ...

# 도커

- window에서 개발 but 서버에 올렸더니 에러

  왜냐하면 서버는 리눅스 환경

- 1. 서버와 윈도우 둘 다에 도커 설치
  2. 도커 파일 생성(구현하고 싶은 환경 설정)
  3. 서버, 컴퓨터 둘 다에 도커파일 주기
     - 도커는 설정한 환경과 같은 virtual container 생성