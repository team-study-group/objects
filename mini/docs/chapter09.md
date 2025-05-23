# Chapter09> 유연한 설계

## 📌 학습 내용 요약

### 1. 개방 폐쇄 원칙 (OCP)
- 컴파일타임 의존성을 고정시키고 런타임 의존성을 변경하라.
- 기존 코드를 수정할 필요 없이, 새로운 클래스를 추가하는 것만으로 새로운 할인 정책 확장
- 추상화 부분은 수정에 대해 닫혀있다. (문맥이 변경되더라도 공통의 부분은 변경되지 않아야한다.)
- 변하지 않는 부분을 고정하고, 변하는 부분을 생략하는 추상화 매커니즘.
- 단순하게 추상화를 했다고 OCP를 지킨게 아니라,
  변경 되지 않을 부분을 신중하게 결정하고 올바른 추상화를 주의깊게 선택했기 때문이다.

### 2. 생성 사용 분리
- 추상화에 의존하기 위해서는 구체클래스의 인스턴스를 직접 생성하지 않도록 주의.
- 객체를 생성할 책임을 client에 전달
- Factory
    - 생성과 사용을 분리하기 위해 객체 생성에 특화된 객체를 `Factory`라고 부른다.
    - 도메인 모델에 속하지 않고, 순수하게 기술적인 결정.
    - 결합도를 낮추고 재사용성을 높이기 위해, 도메인 개념에 속하지 않는 ‘객체 생성’만을 책임지는 가공 클래스를 만드는것
- 시스템을 객체로 나누는 방법 2가지: 표현적 분해, 행위적 분해
    - 표현적 분해: 도메인 모델에 담긴 개념과 관계를 따르며 도메인과 소프트웨어 사이의 표현적 차이를 최소화하는 것
    - 행위적 분해: 모든 책임을 도메인 객체에 할당하면 낮은 응집도, 높은 결합도, 재사용성 저아와 같은 문제가 발생할 수가 있어서, 설계자의 편의를 위해 임의로 만든 가공  객체에게 책임을 할당해서 해결
      (도메인과 무관한 인공 객체: Pure fabrication, 순수 가공물)
- 설계자로서의 우리의 역할은 도메인 추상화를 기반으로 애플리케이션 로직을 설계하는 것과 동시에
  품질의 측면에서 균형을 맞추는 데 필요한 객체들을 창조하는 것.

### 3. 의존성 주입
- 의존성 주입(DI): 외부에서 독립적인 객체가 인스턴스를 생성한 후, 이를 전달해서 의존성을 해결하는 방법
  외부에서 의존성의 대상을 해결하고 이를 사용하는 객체쪽으로 주입하기 때문이다.
- 의존성 주입방법
    - constructor: 객체 생성시점에 주입
    - setter: 의존성의 대상을 런타임에 교체할 수 있지만, 어떤 의존성이 필수인지 알릴 수 없다는 단점이 있음. 객체 생성후에야 호출이 되기 때문에 setter 메서드 호출을 누락하면 비정상 동작을 할 수도 있다;
    - method: 메서드가 의존성을 필요로 하는 경우가 유일할 때 사용
- SERVICE LOCATOR 패턴
    - 저자는 비추.. 의존성 관계가 감춰져있기 때문에
    - Service Locator라고 해서 인스턴스 생성, 반환을 해주는 class를 따로 만들어서
      인스턴스 생성을 별도로 함 (Factory와의 차이점은 Factory 패턴안에는 퍼블릭 인터페이스에 의존성 방향이 보이는데, Service Locator에는 안보인다는게 문제임)
- 명시적인 의존성이 숨겨진 의존성보다 좋다.

### 4. 의존성 역전 원칙
- 유연하고 재사용 가능한 설계를 원한다면,
  모든 의존성의 방향이 추상클래스나 인터페이스같은 추상화를 따라야한다.
- DIP
    - 상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안되고, 둘 다 추상화에 의존해야한다.
    - 구체적인 사항이 추상화에 의존해야한다.
- Separated interface 패턴
    - 구현과 인터페이스를 분리하여 시스템의 유연성과 확장성을 높이는 방법

### 5. 유연성에 대한 조언
- 설계의 미덕은 단순함과 명확함  ↔ 유연한 설계는 복잡한 설계 (trade off)
- 설계를 유연하게 만들기 위해서는 먼저 역할, 책임, 협력에 초점을 맞춰야한다.
- 객체를 생성할 책임을 담당할 객체나 객체 생성 매커니즘을 결정하는 시점은 책임할당의 마지막 단계로 미뤄야 한다.

## 💡 느낀 점
- 추상화를 했다고 무조건 OCP를 지킨게 아니라, 변경되지 않을 부분을 신중하게 잘 골라서 결정하고 추상화를 했느냐가 중요하다.
- 생성과 사용의 책임을 분리하고 생성에 대한 책임을 마지막 단계로 미룸으로써, 불필요한 세부사항에 객체를 결합시키지 않을 수 있다. 

## ❓ 궁금한 점
- Spring이 Bean을 관리하는것도 생성의 책임을 분리한것과 같은 개념인거 같은데 맞는걸까..?




## 🔗 참고 링크
