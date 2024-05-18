# **도를 깎자**

## 서비스 소개

> ‘도를 깎자’는 빠르게 흘러가는 일상 속에서 자아성찰을 할 시간이 없다는 문제를 해결하고 자신의 마음을 돌아볼 수 있는 질문에 답변하고 돌을 깎음으로써, 마음의 평온을 찾고 싶어 하는 사람들에게 유익하다.

## 개발자 소개

| 정준서      | 백은서        | 
|----------|------------|
| sunseo18 | eunseo5343 |

![image](https://github.com/34th-SOPKATHON-ANDROID-TEAM3/SERVER/assets/78674565/badd1300-748f-4a0e-956b-cb6bc10f7fb2)


## API 명세서와 역할 분배 (각자 개발 담당 부분)

| 기능         | HttpMethod | 이름    | url                         |
|------------|------------|-------|-----------------------------|
| 오늘의 돌 조회하기 | GET        | @정준서  | {{baseUrl}}/stones/today    |
| 답변 입력하기    | PATCH      | @정준서  | {{baseUrl}}/stones/today    |
| 모은 돌 전체보기  | GET        | @은서 백 | {{baseUrl}}/stones          |
| 모은 돌 상세보기  | GET        | @은서 백 | {{baseUrl}}/stones/:stoneId |

## 코드 컨벤션

1. **컨트롤러 메서드명**
    1. *GET PATCH PUT POST DELETE로 시작하기!*
    2. ex) 오늘의 돌 조회하기: getTodayStone()

       전체 모은 돌 조회하기: getStones()

       돌 정보 상세 조회하기: getStone()


2. **url**

   URL은 RESTful API 설계 가이드에 따라 작성합니다.

   HTTP Method로 구분할 수 있는 get, put 등의 행위는 url에 표현하지 않습니다.

   마지막에 / 를 포함하지 않습니다.

   /api로 시작합니다

   _ 대신 -를 사용합니다.

   소문자를 사용합니다.

   확장자는 포함하지 않습니다.

   복수형을 사용합니다

   ex) /api/stones /api/stones/:stoneId


3. **네이밍**

   ❗ ***컨플릭트 예방을 위해서 Controller, Service 명에 이름을 포함합니다
   
   ex) EunseoStoneController, JunseoStoneController**

   dto 파일 명은 다음으로 통일합니다

   (Simple) + [동작] + [엔티티명] + [Response/Request] + Dto


       - 클래스 : **PascalCase,** and·or와 같은 접속사를 사용하지 않고 25자 내외로 작성합니다.
       - 함수 : **camelCase**
       - 변수: **camelCase**
       - DB 테이블: **snake_case**
       - ENUM, 상수: **PascalCase**
       - 컬렉션(Collection): **복수형**을 사용하거나 **컬렉션을 명시합니다**. (Ex. userList, users, userMap)
       - LocalDateTime: 접미사에 **Date 혹은 At**를 붙입니다.

## 프로젝트 폴더링

```json
🗂️ **project**
|
|_  🗂️ **common**
|    |_ 🗂️ exception
|
|_  🗂️ **config**
|
|_  🗂️ **domain**
|
|_  🗂️ **stone**
|
|_  🗂️ controller
|    |
|    |_  🗂️ dto
|
|
|_  🗂️ service

```

## ERD

![image](https://github.com/34th-SOPKATHON-ANDROID-TEAM3/SERVER/assets/78674565/b8f4f3f0-064e-493d-a515-5a4d6a34cf98)

