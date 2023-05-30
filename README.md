
## Development Environment

- <img src="https://img.shields.io/badge/Windows-blue?style=flat&logo=windows&logoColor=white"/> 
- <img src="https://img.shields.io/badge/intellij-red?style=flat&logo=intellijidea&logoColor=white"/> 
- <img src="https://img.shields.io/badge/JDK_1.8-red?style=flat&logo=&logoColor=white"/>
- <img src="https://img.shields.io/badge/MySQL-blue?style=flat&logo=mysql&logoColor=white"/>
- <img src="https://img.shields.io/badge/Maven-pink?style=flat&logo=gradle&logoColor=white"/>
- <img src="https://img.shields.io/badge/Github-grey?style=flat&logo=github&logoColor=white"/>

## Dependencies
- ````Spring Web````
- ````Srping JDBC````
- ````DevToos````
- ````Spring Data JPA````
- ````MySql Database````
- ````Lombok````
- ````json-simple````
- ````thymeleaf````
- ````Mail````


## 1️⃣ 요구사항


### ✅ 회원 로그인시 로그인 히스토리(로그) 기능 

- 로그인 히스토리 테이블(login_history)에 로그인 아이디와 로그인 날짜, 접속 IP, 접속 UserAgent를 저장

![save_login_log](https://github.com/jinyngg/fastlms3-project/assets/96164211/5113f2c2-2fdb-4c03-a362-b9a204b8224d)

```완료```

### ✅ 관리자 회원 상세 정보에 로그인 목록 보기 기능

![image](https://github.com/jinyngg/fastlms3-project/assets/96164211/869a0ef0-bcd9-40e4-ab7c-66639043403f)

![detail_add_login_history](https://github.com/jinyngg/fastlms3-project/assets/96164211/f7b4d07a-a999-40a9-8c00-ac5ccb3a2545)

```완료```

### ✅ 배너관리(백오피스 기능)
- 배너 등록 기능은 배너 이미지 파일, 배너 Alter텍스트(대체 텍스트), 배너 링크 했을때 이동하는 URL정보, 클릭시Target정보(새창인지, 현재창 이동인지), 정렬순서, 프론트 표시 여부 정보가 저장

#### 배너 등록

![banner_add](https://github.com/jinyngg/fastlms3-project/assets/96164211/ed16f156-3840-486d-91f1-554b1972cc74)

```완료```

#### 배너 출력

![image](https://github.com/jinyngg/fastlms3-project/assets/96164211/cd33e743-69e9-411a-967f-8cb44aa20582)

```미완성```

<br>

1. 삭제 기능 구현 필요
2. 이미지 출력 구현 필요
3. 이미지 클릭시 링크 연결 구현 필요
4. 공개 여부에 따른 공개 여부 기능 구현 필요

### ✅ 프론트 배너 노출 기능
- 프론트에 위 내용을 근거로 해서 기능이 구현

```미완성```

## TODO

1. 배너 출력 기능 구현(출력에 대한 세부 기능 구현)
2. 배너 노출 기능 구현
