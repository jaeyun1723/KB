# 알고리즘 스터디
## Do it! 알고리즘 코딩 테스트
## 프로그래머스 코딩 테스트

## 📌 기본 정보
## 공통
- 공통은 Doit! 문제(백준)로 지정하여 풀이 (매주 선별된 문제로 진행, 수요일에 이슈올리기)
- 매주 목요일마다 프로그래머스 문제로 실시간 풀이

## 📌 규칙

1. 매주 각자 풀 문제를 랜덤한 알고리즘으로 1개 정해온다. (사이트 불문)
2. 정해온 문제 또는 part를 [issue로 생성](#✅-issue-생성)
3. `{id}/{문제 번호}`로 branch 생성(문제번호는 링크 URL path 끝 숫자)
4. 본인 id 폴더에 lv 별 폴더 안에 문제 풀이
5. 문제 해결 후 [PR 생성](#✅-pr-생성) - 풀이 설명 추가
6. 매주 수요일 밤 Merge 진행

### ✅ Commit 컨벤션

- `[{id}] Baekjoon / {solved.ac tier} / {문제 번호}. {문제 제목} / 알고리즘&자료구조`
- 알고리즘&자료구조 는 웬만하면 영어로 작성할 것 ex) stack, BFS, DFS, ...
- body에는 간단한 소감? 메모

- `commit example`

  ```zsh
  [Koojiny] Baekjoon / silver2 / 2961. 도영이가 만든 맛있는 음식 / 부분합
  ```

### ✅ Issue 생성

- template 사용
- Issue 제목: `[{Github Id}] n월 n주차`
- Issue 내용

  ```text
  - [ ] {문제 링크} | 문제 구분
  ```

- `gh example`

  ```zsh
  gh issue create
  title: [Koojiny] 3월 3주차
  body:
    - [ ] https://www.acmicpc.net/problem/2961 | 부분합
    - [ ] https://www.acmicpc.net/problem/1759 | 조합
    - [ ] https://www.acmicpc.net/problem/2750 | 정렬
    - [ ] https://www.acmicpc.net/problem/11659 | 구간합
    - [ ] https://www.acmicpc.net/problem/11729 | 재귀
  metadata: assignees - Koojiny
  ```

### ✅ PR 생성

- template 사용
- `{id}/{문제번호}` branch에서 commit 후 PR
- PR 제목: `[{Github Id}] lv{번호} / {문제 번호}. {문제 이름}`
- PR 내용

  ```text
  ## 🔗 연관 이슈
  - 이슈 번호

  <br />

  ## 🔑 설명
  - 설명을 작성해주세요
  ```

- assignee는 youself
- label로 사용 알고리즘&자료구조 명시

- `gh example`

  ```zsh
  gh pr create
  title: [Koojiny] Baekjoon / silver2 / 2961. 도영이가 만든 맛있는 음식
  body:
    {문제 링크}
  metadata: Assignees - Koojiny, label - 부분합
  ```
