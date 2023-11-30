# kotlin-blackjack

## 기능 요구사항
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

 - 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
 - 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

## 프로그래밍 요구 사항
 - 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
 - indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
 - 모든 엔티티를 작게 유지한다.
 - 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
 - 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
 - git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## 구현할 기능 목록
### 점수
 - [x] 숫자 카드는 카드의 숫자를 점수로 계산한다
 - [x] Ace 카드는 1 또는 11로 점수 계산 가능하다
 - [x] King, Queen, Jack은 10으로 계산한다

### 시작
 - [x] 입력한 이름을 기준으로 게임에 플레이어가 정해진다 (플레이어는 유일한 이름을 가진다)

### 카드 분배
 - [x] 플레이어는 최초에 카드 2장을 분배 받는다
 - [x] 카드 분배는 최초 한 번 이루어진다

### 카드 추가
 - [ ] 보유한 카드의 점수 합이 블랙잭 기준치(21) 미만이면 추가로 카드를 받을 수 있다 (21 이상이면 추가로 카드를 받을 수 없다)

### 결과
 - [ ] 최종 점수는 보유한 카드의 점수를 합한 값이다
 - [ ] 최종 점수가 블랙잭 기준치(21)를 넘으면 버스트로 점수와 상관없이 패배이다
 - [ ] Ace 카드는 가능한 한 버스트 되지 않고 가장 큰 점수를 받을 수 있도록 계산한다
