# **도를 깎자**

## 서비스 소개

> ‘도를 깎자’는 빠르게 흘러가는 일상 속에서 자아성찰을 할 시간이 없다는 문제를 해결하고 자신의 마음을 돌아볼 수 있는 질문에 답변하고 돌을 깎음으로써, 마음의 평온을 찾고 싶어 하는 사람들에게 유익하다.

## 개발자 소개

| 정준서      | 백은서        | 
|----------|------------|
| sunseo18 | eunseo5343 |

![Untitled](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F82bc89ea-0929-4ab7-b82a-52f74dabcc20%2F0692cf58-2e3c-4bc8-8b27-b46da3f469c9%2FUntitled.png?table=block&id=af0d1434-fce5-4f86-afad-ef892f697305&spaceId=82bc89ea-0929-4ab7-b82a-52f74dabcc20&width=2000&userId=0cab8c43-cb75-4761-bcb7-aa3ab61ac5f5&cache=v2)

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

![Untitled](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F82bc89ea-0929-4ab7-b82a-52f74dabcc20%2F20a4a4be-13ff-41d9-a4cb-aebad2b39ff4%2FUntitled.png?table=block&id=e5cf13e6-087a-4729-802a-1dcb1899b432&spaceId=82bc89ea-0929-4ab7-b82a-52f74dabcc20&width=2000&userId=0cab8c43-cb75-4761-bcb7-aa3ab61ac5f5&cache=v2)
