# CHAPTER3 운영체제
## SECTION1 운영체제와 컴퓨터
- 운영체제(OS, Operating System)
  - 사용자가 컴퓨터를 쉽게 다루게 해주는 인터페이스
  - 한정된 메모리나 시스템 자원을 효율적으로 분배
  - cf) 펌웨어(firmware) : 소프트웨어를 추가로 설치할 수 없는 것

### 3.1.1 운영체제의 역할과 구조
#### 운영체제의 역할
- CPU 스케줄링과 프로세스 관리
  - CPU 소유권을 어떤 프로세스에 할당할지, 프로세스의 생성과 삭제, 자원 할당 및 반환을 관리
- 메모리 관리
  - 한정된 메모리를 어떤 프로셋에 얼마큼 할당해야하는지 관리
- 디스크 파일 관리
  - 디스크 파일을 어떠한 방법으로 보관할지 관리
- I/O 디바이스 관리
  - I/O 디바이스들인 마우스, 키보드와 컴퓨터 간에 데이터를 주고받는 것을 관리

#### 운영체제의 구조
![운영체제의 구조](https://velog.velcdn.com/images/ank0425/post/ce9b8d43-8532-4244-9d47-ab36ba6f1265/image.png)

- 시스템콜
  - 운영체제가 커널에 접근하기 위한 인터페이스
  - 유저 프로그램이 운영체제의 서비스를 받기 위해 커널 함수를 호출할 때 사용
  - 프로세스나 스레드에서 운영체제로 어떠한 요청을 할 때 시스템콜이라는 인터페이스와 커널을 거쳐 운영체제에 전달
  - 하나의 추상화 계층
  - 장점 : 네트워크 통신이나 데이터베이스와 같은 낮은 단계의 영역 처리에 대한 부분을 많이 신경 쓰지 않고 프로그램을 구현가능
  - modebit : 플래그 변수
    - 유저모드와 커널모드 구분

### 3.1.2 컴퓨터의 요소
- CPU, DMA 컨트롤러, 메모리, 타이머, 디바이스 컨트롤러

- CPU(Central Processing Unit) : 컴퓨터장치, 인터럽트에 의해 단순히 메모리에 존재하는 명령어를 해석해서 실행하는 일꾼
  - 제어장치(CU, Control Unit)
    - 프로세스 조작을 지시한는 CPU의 한 부품
    - 입출력장치 간 통신 제어
    - 명령어들을 읽고 해석
    - 데이터 처리를 위한 순서 결정

  - 레지스터
    - CPU 안에 있는 매우 빠른 임시기억장치
    - CPU와 직접 연결 -> 연산 속도가 메모리보다 빠름
    - CPU 데이터 저장시 거쳐감

  - 산술논리연산장치(ALU, Arithmetic Logic Unit)
    - 덧셈, 뺄셈 같은 두 숫자의 산술 연산과 배타적 논리합, 논리곱 같은 논리 연산을 계산하는 디지털 회로

  - 인터럽트
    - 어떤 신호가 들어왔을 떄 CPU를 잠깐 정지시키는 것
    - IO 디바이스로 인한 인터럽트, 0으로 숫자를 나누는 산술 연산에서의 인터럽트, 프로세스 오류 등으로 발생
    - 인터럽트 발생시 인터럽트 핸들러 함수가 모여있는 인터럽트 벡터로 가서 인터럽트 핸드러 함수 실행
    - 인터럽트간 우선순위, 우선순위에 따라 실행
    - 하드웨어 인터럽트
      - IO 디바이스에서 발생하는 인터럽트
      - ex) 키보드, 마우스
    - 소프트웨어 인터럽트
      - (= 트랩, trap)
      - 프로세스 오류 등으로 프로세스가 시스템콜을 호출할 때 발동

- DMA 컨트롤러
  - I/O 디바이스가 메모리에 직접 접근할 수 있도록 하는 하드웨어 장치
  -  CPU 부하를 막아주며 CPU의 일을 부담하는 보조 일꾼
  -  하나의 작업을 CPU와 DMA 컨트롤러가 동시에 하는 것 방지

- 메모리
  - 전자회로에서 데이터나 상태, 명령어 등을 기록하는 장치
  - 보통 RAM(Random Access Memory)을 일컬어 메모리라고 함

- 타이머
  - 몇 초 안에는 작업이 끝나야 한다는 것을 정하고 특정 프로그램에 시간제한을 다는 역할
  - 시간이 많이 걸리는 프로그램이 작동할 때 제한을 걸기 위해 존재

- 디바이스 컨트롤러
  - 컴퓨터와 연결되어 있는 IO 디바이스들의 작은 CPU
  - 로컬 버퍼
    - 옆에 붙어있음
    - 각 디바이스에서 데이터를 임시로 저장하기위한 작은 메모리
## SECTION2 메모리
### 3.2.1 메모리 계층
- 레지스터, 캐시, 메모리, 저장장치
![메모리 계층](https://velog.velcdn.com/images%2Fyu-jin-song%2Fpost%2Ff9c8088c-0fec-4dad-ac95-ddf3601aa1d4%2F%EB%A9%94%EB%AA%A8%EB%A6%AC_%EA%B3%84%EC%B8%B5_%EA%B5%AC%EC%A1%B0.png)
- 레지스터
  - CPU안에 있는 작은 메모리
  - 휘발성
  - 속도 가장 빠름
  - 기억용량 가장 적음
- 캐시
  - L1, L2 캐시 지칭
  - 휘발성
  - 속도 빠름
  - 기억 용량이 적음
- 주기억장치
  - RAM을 가르킴
  - 휘발성
  - 속도 보통
  - 기억 용량 보통
- 보조기억장치
  - HDD, SSD
  - 비휘발성
  - 속도 낮음
  - 기억 용량 많음

#### 캐시(cache)
- 데이터를 미리 복사해 놓은 임시 저장소이자 빠른 장치와 느린 장치에서 속도 차이에 따른 병목 현상을 줄이기 위한 메모리
- 데이터를 접근하는 시간이 오래 걸리는 경우 해결
- 무언가를 다시 계산하는 시간 절약가능

- 지역성의 원리 : 자주 사용하는 데이터를 기반으로 설정
  - 시간 지역성(temporal locality)
    - 최근 사용한 데이터를 다시 접근하려는 특성
  - 공간 지역성(spatial locality)
    - 최근 접근한 데이터를 이루고 있는 공간이나 그 가까운 공간에 접근하는 특성

#### 캐시히트와 캐시미스
- 캐시히트
  - 캐시에서 원하는 데이터를 찾은 경우
  - 해당 데이터를 제어장치를 거쳐 가져오게 됨
  - 위치 가깝
  - CPU 내부 버스를 기반으로 작동 -> 빠름
- 캐시미스
  - 해당 데이터가 캐시에 없어 주메모리로 가서 데이터를 찾아오는 것
  - 시스템 버스를 기반으로 작동하기 때문에 느림

#### 캐시매핑
- 캐시가 히트되기 위해 매핑하는 방법
- 직접 매핑
  - 처리가 빠르지만 총돌 발생이 잦음
- 연관 매핑
  - 순서를 일치시키지 않고 관련 있는 캐시와 메모리 매핑
  - 충돌이 적지만 모든 블록을 탐색해야 해서 속도가 느림
- 집합 연관 매핑
  - 직접 매핑 + 연관 매핑
  - 집합을 둬서 저장하며 블록화되어 있음
  - 검색이 좀 더 효율적

#### 웹 브라우저의 캐시
- 쿠키
  - 만료기한이 있는 키-값 저장소
  - same site 옵션을 strict로 설저하지 않았을 경우 다르 도메인에서 요청했을 떄 자동 전송
  - 4KB까지 데이터 저장
  - 만료기한 정할 수 있음
  - 쿠키 설정시 document.cookie로 쿠키를 볼 수 없게 httponly 옵션을 거는 것 중요
  - 보통 서버에서 만료기한 정함

- 로컬 스토리지
  - 만료기한이 없는 키-값 저장소
  - 10MB까지 저장
  - 웹 브라우저를 닫아도 유지되고 도메인 단위로 저장,생성
  - 클라이언트에서만 수정 가능

- 세션 스토리지
  - 만료기한이 없는 키-값 저장소
  - 탭 단위로 세션 스토리지 생성
  - 탭을 닫을 때 해당 데이터 삭제
  - 5MB까지 저장가능
  - 클라이언트에서만 수정 가능

#### 데이터베이스의 캐싱 계층
- 메인 데이터베이스 위에 레디스(REDIS) 데이터베이스 계층을 '캐싱 계층'으로 둬서 성능 향상

### 3.2.2 메모리 관리
- 운영체제의 대표적인 할 일 중 하나

#### 가상 메모리(virtual memory)
- 메모리 관리 기법의 하나
- 컴퓨터가 실제로 이용 가능한 메모리 자원을 추상화하여 이를 사용하는 사용자들에게 매우 큰 메모리로 보이게 만드는 것
  - 가상 주소(logical address) : 가상적으로 주어진 주소
    - 메모리관리장치(MMU)에 의해 실제 주소로 변환, 사용자는 실제 주소를 의식할 필요 없음
  - 실제 주소(physical address) : 실제 메모리 상에 있는 주소
- 가상 주소와 실제 주소가 매핑
- 프로세스의 주소 정보가 들어 있는 '페이지 테이블'로 관리
- 속도 향상을 위해 TLB 사용
  
- 스와핑
  - 만약 가상 메모리에는 존재하나 실제 메모리인 RAM에 현재 없는 데이터나 코드에 접근할 경우 페이지 폴트 발생
  - 이때 메모리에서 당장 사용하지 않는 영역을 하드디스크로 옮기고 하드디스크의 일부분을 마치 메모리처럼 불러와 쓰는 것
  - 마치 페이지 폴트가 일어나지 않은 것 처럼 만듦
- 페이지 폴트(page fault)
  - 프로세스의 주소 공간에는 존재하나 지금 이 컴퓨터 RAM에는 없는 데이터에 접근했을 경우 발생

#### 스레싱
- 메모리의 페이지 폴트율이 높은 것
- 성능 저하 초래
- 메모리에 너무 많은 프로세스가 동시에 올라가게 되면 스와핑 많이 일어나서 발생
- 해결방법
  - 메모리 늘리기
  - HDD -> SSD 바꾸기
- 운영체제를 활용한 해결방법
  - 작업 세트(working set)
    - 프로세스의 과거 사용 이력인 지역성을 통해 결정된 페이지 집합을 만들어서 미리 메모리에 로드
    - 비용 줄이기 가능
    - 스와핑 줄이기 가능
  - PFF(Page Fault Frequency)
    - 페이지 폴트 빈도를 조절하는 방법
    - 상한선과 하한선을 만드는 방법

#### 메모리 할당
- 메모리에 프로그램을 할당할 때는 시작 메모리 위치, 메모리의 할당 크기를 기반으로 할당
- 연속 할당
  - 메모리에 '연속적'으로 공간을 할당하는 것(순차적)
  - 고정 분할 방식(fixed partition allocation)
    - 메모리를 미리 나누어 관리하는 방식
    - 융통성이 없음
    - 내부 단편화 발생(메모리를 나눈 크기 > 프로그램)
  - 가변 분할 방식(variable partition allocation)
    - 매 시점 프로그램의 크기에 맞게 동적으로 메모리를 나눠 사용
    - 내부 단편화 발생하지 않음
    - 외부 단편화 발생(메모리 나눈 크기 < 프로그램)
    - 최초적합(first fit)
      - 위쪽이나 아래쪽부터 시작, 홀을 찾으면 바로 할당
    - 최적적합(best fit)
      - 프로세스의 크기 이상인 공간 중 가장 작은 홀부터 할당
    - 최악적합(worst fit)
      - 프로세스의 크기와 가장 많이 차이가 나는 홀에 할당

- 불연속 할당
  - 메모리를 연속적으로 할당하는 않는 방법
  - 현대 운영체제가 쓰는 방법
  - 페이징(paging)
    - 동일한 크기의 페이지 단위로 나눠 메모리의 서로 다른 위치에 프로세스 할당
    - 장점 : 홀의 크기가 균일
    - 단점 : 주소 변환 복잡
  - 세그멘테이션(segmentation)
    - 페이지 단위가 아닌 의미 단위인 세그먼트로 나누는 방식
    - 장점 : 공유와 보안 측면
    - 단점 : 홀 크기가 균일하지 않음
  - 페이지드 세그멘테이션(paged segmentation)
    - 프로그램을 의미 단위인 세그먼트로 나눠 공유나 보안 측면에서 강점을 두고 임의의 길이가 아닌 동일한 크기의 페이지 단위로 나누는 것

#### 페이지 교체 알고리즘
- 스와핑은 많이 일어나지 않도록 설계되어야 함
- 이를위해 페이지 교체 알고리즘을 기반으로 스와핑이 일어남

- 오프라인 알고리즘(offline algorithm)
  - FIFO(First In First Out)
    - 가장 먼저 온 페이지를 교체 영역에 가장 먼저 놓는 방법
  - LRU(Least Recentle Used)
    - 참조가 가장 오래된 페이지를 바꾸는 방법
    - 문제점 : 오래된 것을 파악하기 위해 각 페이지마다 계수기, 스택을 두어야 함
    - 프로그래밍으로 구현시 해시 테이블과 이중 연결 리스트를 사용
      - 해시 테이블 : 이중 연결 리스트에서 빠르게 찾을 수 있도록 사용
      - 이중 연결 리스트 : 한정된 메모리 나타냄
  - NUR(Not Used Recently)
    - LRU에서 발전
    - clock 알고리즘
    - 0(참조되지 않음), 1(최근에 참조)
    - 시계방향으로 돌면서 0을 찾고 0을 찾은 순간 해당 프로세스를 교체, 해당 부분을 1로 바꾸는 알고리즘
  - LFU(Least Frequently USed)
    - 가장 참조 횟수가 적은 페이지 교체
    - = 많이 사용되지 않는 것을 교체

## SECTION3 프로세스와 스레드
- 프로세스(process)
  - 컴퓨터에서 실행되고 있는 프로그램
  - CPU 스케줄링의 대상이 되는 작업(task)이라는 용어와 거의 같은 의미로 사용

- 스레드(thread)
  - 프로세스 내 작업의 흐름

### 3.3.1 프로세스와 컴파일 과정
- 프로세스 : 프로그램이 메모리에 올라가 인스턴스화된 것
- 컴파일러가 컴파일 과정을 통해 컴퓨터가 이해할 수 있는 기계어로 번역하여 실행할 수 있는 파일을 만들게 됨 (C언어 기준)

- 컴파일 과정
  - 전처리
    - 소스 코드의 주석을 제거하고 #include 등 헤더 파일을 병합하여 메크로 치환
  - 컴파일러
    - 오류 처리, 코드 최적화 작업, 어셈블리어로 변환
  - 어셈블러
    - 목적 코드(object code)로 변환
    - 확장자는 운영체제마다 다름
  - 링커
    - 프로그램 내에 있는 라이브러리 함수 또는 다른 파일들과 목적 코드를 결합하여 실행 파일을 만듦
    - 확장자 : .exe 또는 .out
      - 정적 라이브러리
        - 프로그램 빌드 시 라이브러리가 제공하는 모든 코드를 실행 파일에 넣는 방식
        - 장점 : 시스템 환경 등 외부 의존도가 낮음
        - 단점 : 코드 중복 등 메모리 효율성 떨어짐
      - 동적 라이브러리
        - 프로그램 실행 시 필요 할 때만 DLL이라는 함수 정보를 통해 참조하여 라이브러리 사용
        - 장점 : 메모리 효율성 좋음
        - 단점 : 외부 의존도가 높아짐

### 3.3.2 프로세스의 상태
- 생성 상태(create)
  - 프로세스가 생성된 상태
  - fork()나 exec() 함수를 통해 생성
  - 이때 PCB 할당됨
    - fork()
      - 부모 프로세스의 주소 공간 그대로 복사, 새로운 자식 프로세스를 생성하는 함수
    - exec()
      - 새롭게 프로세스를 생성하는 함수

- 대기 상태(ready)
  - 메모리 공간이 충분하면 메모리 할당받고 아니면 아닌 상태로 대기
  - CPU 스케줄러부터 CPU 소유권이 넘어오기를 기다리는 상태

- 대기 중단 상태(ready suspended)
  - 메모리 부족으로 일시 중단된 상태

- 실행 상태(running)
  - CPU 소유권과 메모리를 할당받고 인스트럭션을 수행 중인 상태
  - CPU burst가 일어났다고 표현하기도 함

- 중단 상태(blocked)
  - 어떤 이벤트가 발생한 이후 기다리며 프로세스가 차단된 상태
  - I/O 디바이스에 의한 인터럽트로 이런 현상이 많이 발생되기도 함

- 일시 중단 상태(blocked suspended)
  - 대기 중단과 유사
  - 중단된 상태에서 프로세스가 실행되려고 했지만 메모리 부족으로 일시 중단된 상태

- 종료 상태(terminated)
  - 메모리와 CPU 소유권을 모두 놓고 가는 상태
  - 자연스럽게 종료
  - 부모 프로세스가 자식 프로세스를 강제시키는 비자발적 종료(alert)
    - 자식 프로세스에 할당된 자원의 한계치를 넘어서거나
    - 부모 프로세스가 종료되거나
    - 사용자가 process.kill 등 여러 명령어로 프로세스를 종료할 떄

### 3.3.3 프로세스의 메모리 구조
- 스택과 힙
  - 동적 할당
    - 런타임 단계에서 메모리를 할당받는 것
  - 스택
    - 지역변수, 매개변수, 실행되는 함수에 의해 늘어들거나 줄어드는 메모리 영역
    - 함수가 호출될 때마다 호출될 때의 환경 등 특정 정보가 스택에 계속해서 저장
  - 힙
    - 동적으로 할당되는 변수를 담음
    - malloc(), free() 함수를 통해 관리
    - 동적으로 할당되는 경우 힙 영역 사용

- 데이터 영역과 코드 영역
  - 정적 할당
    - 컴파일 단계에서 메모리를 할당하는 것
    - BSS segment와 Data segment, code/text segment로 나뉨
    - BSS segment
      - 전역 변수 또는 static, const로 선언
      - 0으로 초기화 또는 초기화가 어떠한 값으로도 되어 있지 않은 변수들이 이 메모리 영역에 할당
    - Data segment
      - 전역 변수 또는 static, const로 선언
      - 0이 아닌 값으로 초기화된 변수가 이 메모리 영역에 할당
    - code segment : 프로그램의 코드가 들어옴
### 3.3.4 PCB(Process Control Block)
- 운영체제에서 프로세스에 대한 메타데이터를 저장한 '데이터'
- (= 프로세스 제어 블록)
- 프로세스 생성 시 운영체제는 해당 PCB 생성

- PCB의 구조
  - 프로세스 스케줄링 상태
    - '준비', '일시중단' 등 프로세스가 CPU에 대한 소유권을 얻은 이후의 상태
  - 프로세스 ID
    - 프로세스 ID, 해당 프로세스의 자식 프로세스 ID
  - 프로세스 권한
    - 컴퓨터 자원 또는 I/O 디바이스에 대한 권한 정보
  - 프로그램 카운터
    - 프로세스에서 실행해야 할 다음 명령어의 주소에 대한 포인터
  - CPU 레지스터
    - 프로세스를 실행하기 위해 저장해야 할 레지스터에 대한 정보
  - CPU 스케줄링 정보
    - CPU 스케줄러에 의해 중단된 시간 등에 대한 저보
  - 계정 정보
    - 프로세스 실행에 사용된 CPU 사용량, 실행한 유저의 정보
  - I/O 상태 정보
    - 프로세스에 할당된 I/O 디바이스 목록

- 컨텍스트 스위칭
  - 앞서 설명한 PCB를 교환하는 과정
  - 한 프로세스에 할당된 시간이 끝나거나 인터럽트에 의해 발생
    - 비용 : 캐시미스
    - 스레드에서의 컨텍스트 스위칭 : 비용이 더 적고 시간이 더 적게 걸림
### 3.3.5 멀티프로세싱
- 멀티프로세스를 통해 동시에 두 가지 이상의 일을 수행할 수 있는 것
- 하나 이상의 일을 병렬로 처리가능
- 특정 프로세스이 메모리,프로세스 중 일부에 문제가 발생되더라도 다른 프로세스를 이용해서 처리
- 신뢰성이 높음

- 웹 브라우저
  - 브라우저 프로세스 : 주소 표시줄, 북마크 막대, 뒤로 가기 버튼, 앞으로 가기 버튼 등을 담당, 네트워크 요청이나 파일 접근 같은 권한 담당
  - 렌더러 프로세스 : 웹 사이트가 '보이는' 부분의 모든 것 제어
  - 플러그인 프로세스 : 웹 사이트에서 사용하는 플로그인 제어
  - GPU 프로세스 : GPU를 이용해서 화면을 그리는 부분 제어

- IPC(Inter Process Communication)
- 프로세스끼리 데이터를 주고받고 공유 데이터를 관리하는 메커니즘
  - 공유 메모리
    - 여러 프로세스에 동일한 메모리 블록에 대한 접근 권한이 부여
    - 프로세스가 서로 통신할 수 있도록 공유 메모리를 생성해서 통신하는 것
    - 불필요한 데이터 복사의 오버헤드 발생하지 않아 가장 빠름
    - 같은 메모리 영역을 여러 프로세스가 공유 -> 동기화 필요
  - 파일
    - 디스크에 저장된 데이터 또는 파일 서버에서 제공한 데이터
  - 소켓
    - 동일한 컴퓨터의 다른 프로세스나 네트워크의 다른 컴퓨터로 네트워크 인터페이스를 통해 전송하는 데이터
    - TCP, UDP
  - 익명 파이프
    - 프로세스 간에 FIFO 방식으로 읽히는 임시 공간이 파이프를 기반으로 데이터를 주고받음
    - 단방향 방시그이 읽기전용, 쓰기 전용 파이프를 만들어서 작동하는 방식
    - 부모, 자식 간에만 사용가능
    - 다른 네트워크상에서는 사용불가
  - 명명된 파이프
    - 파이프 서버와 하나 이상의 파이프 클라이언트 간의 통신을 위한 명명된 단방향 또는 양방향 파이프
    - 클라이언트/서버 통신을 위한 별도의 파이프 제공
    - 여러 파이프 동시 사용
    - 컴퓨터의 프로세스끼리 또는 다른 네트워크상의 컴퓨터와 통신가능
  - 메시지 큐
    - 메시지를 큐 데이터 구조 형태로 관리하는 것
    - 커널의 전여변수 형태 등 커널에서 전역적으로 관리
    - 다른 IPC방식에 비해 사용 방법이 매우 직관적, 간단
    - 다른 코드의 수정 없이 단지 몇 줄의 코드 추가시켜 간단하게 메시지 큐에 접근가능

### 3.3.6 스레드와 멀티스레딩
- 스레드
  - 프로세스의 실행 가능한 가장 작은 단위
  - 프로세스는 여러 스레드를 가질 수 있음

- 멀티스레딩
  - 프로세스 내 작업을 여러 개의 스레드, 멀티스레드로 처리하는 기법
  - 스레드끼리 서로 자원을 공유 -> 효율성이 높음
  - 장점
    - 한 스레드가 중단되어도 다른 스레드는 실행상태일 수 있기 때문에 중단되지 않은 빠른 처리 가능
    - 동시성
  - 단점
    - 한 스레드에 문제가 생기면 다른 스레드에도 영향을 끼쳐 스레드로 이루어져 있는 프로세스에 영향을 줄 수 있음
  
### 3.3.7 공유 자원과 임계 영역
- 공유 자원
  - 시스템 안에서 각 프로세스, 스레드가 함께 접근할 수 있는 모니터, 프린터, 메모리, 파일, 데이터 등의 자원이나 변수 등을 의미
  - 경쟁상태(race condition) : 공유 자원을 두 개 이상의 프로세스가 동시에 읽거나 쓰는 상황
  - 동시에 접근을 시도할 때 접근의 타이밍이나 순서 등이 결괏값에 영향을 줄 수 있는 상태
  
- 임계 영역
  - 둘 이상의 프로세스, 스레드가 공유 자원에 접근할 때 순서 등의 이유로 결과가 달라지는 코드 영역
  - 상호배제, 한정 대기, 융통성이란 조건 만족

  - 뮤텍스
    - 프로세스나 스레드가 공유 자원을 lock()을 통해 잠금 설정하고 사용한 후 unlock()을 통해 잠금 해제하는 객체
  - 세마포어
    - 일반화된 뮤텍스
    - 간단한 정수 값과 두 가지 함수 wait 및 signal로 공유 자원에 대한 접근 처리
    - 바이너리 세마포어
      - 0과 1의 두 가지 값만 가질 수 있는 세마포어
    - 카운팅 세마포어
      - 여러 개의 값을 가질 수 있는 세마포어
      - 여러 자원에 대한 접근을 제어하는데 사용
  - 모니터
    - 둘 이상의 스레드나 프로세스가 공유 자원에 안전하게 접근할 수 있도록 공유자원을 숨기고 해당 접근에 대해 인터페이스 제공

### 3.3.8 교착 상태
- 두 개 이상의 프로세스들이 서로가 가진 자원을 기다리며 중단된 상태
- 교착 상태의 원인
  - 상호 배제
    - 한 프로세스가 자원을 독점
    - 다른 프로세스들은 접근 불가
  - 점유 대기
    - 특정 프로세스가 점유한 자원을 다른 프로세스가 요청하는 상태
  - 비선점
    - 다른 프로세스의 자원을 강제적으로 가져올 수 없음
  - 환형 대기
    - 프로세스 A는 프로세스 B의 자원 요구, 프로세스 B는 프로세스 A의 자원 요구하는 등 서로가 서로의 자원 요구하는 상황 발생
  
- 교착상태 해결방법
  - 자원 살당 시 애초에 조건이 성립되지 않도록 설계
  - 은행원 알고리즘 : 교착 상태 가능성이 없을 때만 자원 할당, 프로세스당 요청할 자원들의 최대치를 통해 자원 할당 가능 여부를 파악
  - 교착 상태 발생시 사이클이 있는지 찾아보고 이에 관련된 프로세스 한 개씩 지우기
  - 현대 운영체제 방법 : 교착상태 발생시 사용자가 작업 종료
## SECTION4 CPU 스케쥴링 알고리즘
- CPU 스케줄러 : CPU 스케줄링 알고리즘에 따라 프로세스에서 해야 하는 일을 스레드 단위로 CPU에 할당
- 프로그램 실행 시 CPU 스케줄링 알고리즘이 어떤 프로그램에 CPU 소유권을 줄 것인지 결정
- 설정 목표
  - 이용률 높게
  - 주어진 시간에 많은 일을 하게
  - 준비 큐에 있는 프로세스는 적게
  - 응답 시간은 짧게
  
### 3.4.1 비선점형 방식
- 프로세스가 스스로 CPU 소유권를 포기하는 방식
- 강제로 프로세스를 중지하지 않음
- 컨텍스트 스위칭으로 인한 부하가 적음

- FCFS(First Come, First Served)
  - 가장 먼저 온 것을 가장 먼저 처리하는 알고리즘
  - 단점 : 준비 큐에서 오래 기다리는 현상(convoy effect) 발생

- SJF(Shortest Job First)
  - 실행 시간이 가장 짧은 프로세스를 가장 먼저 실행하는 알고리즘
  - 긴 시간을 가진 프로세스가 실행되지 않는 현상(starvation)나타남
  - 평균 대기 시간이 가장 짧음
  - 실제로 실행 시간 알 수 없어 과거의 실행했던 시간을 토대로 추측해서 사용

- 우선순위
  - 오래된 작업일수록 '우선순위를 높이는 방법(aging)'을 통해 SJF의 단점을 보완한 알고리즘

### 3.4.2 선점형 방식
- 라운드 로빈(RR, Round Robin)
  - 현대 컴퓨터가 쓰는 스케줄링인 우선순위 스케줄링의 일종
  - 각 프로세스는 동일한 할당 시간을 주고 그 시간 안에 끝나지 않으면 다시 준비 큐의 뒤로 가는 알고리즘

- SRF(Shortest Remaining Time First)
  - 중간에 더 짧은 작업이 들어오면 수행하던 프로세스를 중지, 해당 프로세스를 수행하는 알고리즘

- 다단계 큐
  - 우선순위에 따른 준비 큐를 여러 개 사용
  - 큐마다 라운드 로빈이나 FCFS 등 다른 스케줄링 알고리즘을 적용한 것
  - 큐 간의 프로세스 이동이 안됨
  - 스케줄링 부담이 적으나 유연성이 떨어짐