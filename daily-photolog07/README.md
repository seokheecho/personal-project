# daily-photolog07
 - daily-photolog07 포토로그(PhotoLog)
 - UI 정리 (html / javascript / css)

1) webapp/html

2) package.json(npm 활용)
 
[Scoop 설치]
**참고
 - https://scoop.sh/
 - https://blog.naver.com/chandong83/221101838350

[Node.js 설치]
- scoop 설치 가능한 tools 보기
scoop search
- scoop 으로 nodejs 설치
scoop install nodejs
**환경변수 설정

**nodejs 설치하면 npm 사용가능
[npm version 확인 및 version 업데이트]
 - npm 버전확인
npm -v
 - npm 버전 업데이트
npm install npm -g

[npm 활용]
 - npm 활용하여 tool 설치
npm install
**npm install은 package.json 파일 있는 폴더에서 진행
** 주의! 기존 package-lock.json, node_modules 이 있다면 삭제하고 진행
 - package.json에 추가한 tool 업데이트
npm update
