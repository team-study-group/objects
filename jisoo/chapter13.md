---
book: "오브젝트"
chapter: "챕터 13: 서브클래싱과 서브타이핑"
date: "2025-05-22"
tags: ["책요약", "오브젝트/chapter-13"]
---

# 📖 챕터 13: 서브클래싱과 서브타이핑


## 🧠 핵심 요약  
- 상속의 용도는 1) 타입 계층 구현 2)코드 재사용이 있다. 
	- 타입 계층 구현은 부모클래스에서는 일반적인 개념을 구현하고 자식 클래스에서는 특수한 계념을 구현한다. 
		- 자식 클래스 관점에서 부모 클래스는 _**일반화**_ 
		- 부모 클래스 관점에서 자식 클래스는 _**특수화**_
	- 코드 재사용은 부모 클래스와 자식 클래스가 강결합 되기 때문에 사용하지 않는게 좋다
- 상속은 코드재사용의 용도보다는 타입 계층의 구현 용도로 사용하여야 한다. 
- 타입 계층의 구현은 동일한 메시지에 대해 서로 다르게 행동 할수 있는  다형적인 계층을 구현하는데 의미가 있다. 

#### 타입 
--- 
###### 개념 관점의 타입 
- 타입:  사물을 분류하기한 틀 (자바, 루비, 자바스크립트, c++ -> 프로그래밍언어 (타입))
- 인스턴스 : 어떤 대상이 타입으로 분류될 때 그 대상, 일반적으로 타입의 인스턴스를  __*객체*__  라고 부른다

```
심볼 : 타입에 이름을 붙힌것  
내연 : 타입의 정의로서 타입에 속하는 객체들이 가지는 공통적인 속성이나 행동을 가리킨다. 
외연 : 타입에 속하는 객체들의 집합
```

###### 프로그래밍 언어 관점의 타입 
- 연속적인 비트(bit)에 의미와 제약을 부여하기 위해 사용 
- 타입은 비트 묶음에 의미를 부여하기 위해 정의된 제약과 규칙 

###### 객체지향 패러다임 관점의 타입 
- 타입은 호출 가능한 오퍼레이션의 집합을 정의 
- 오퍼레이션은 객체가 수신할 수 있는 메시지를 의미 
- 즉 객체지향에서 타입을 정의하는 것은 퍼블릭 인터페이스를 정의 하는 것 
- 어떤 객체들이 내부 상태는 다르지만 동일한 퍼블릭 인터페이스를 공휴한다면 이들은 동일한 타입으로 분류된다. 

#### 타입 계층 
###### 타입 사이의 포함관계 
- 타입 계층을 구성하는 두 타입 관계에서 더 일반적인 타입을 **슈퍼타입** 이라고 부르고 특수한 타입을 **서브타입** 이라고 부른다.
- 내연 관점에서 일반화란 어떤 타입의 정으를 좀 더 보편적이고 추상적으로 만드는 과정 
- 특수화란 타입의 정의를 좀 더 구체적이고 문맥 종속적으로 만드는 과정 
- 외연 관점에서 일반적인 타입의 인스턴스 집합은 특수 타입의 인스턴스 집합을 포함하는 슈퍼세이다. 
- 특수한 타입의 인스턴스 집합은 일반적인 타입의 인스턴스에 포함된 서브셋이다. 
객체지향 프로그래밍과 타입 계층
- 더 일반적인 퍼블릭 인터페이스를 가지는 객체들은 더 특ㄹ수한 퍼블릭 인터페이스를 가지는 객체들의 슈퍼타입이다. 
- 서브타입의 인스턴스 집합은 슈퍼타입의 인스턴스 집합의 부분집합 이기 때문에 특수한 더 특수한 퍼블릭 인터페이스를 가지는 객체들은 동시에 더 일번적인 퍼블릭 인터페이스를 가지는 객체들의 집합에 포함된다. 
- 서브타입의 인스턴스는 슈퍼타입의 인스턴스로 간주될 수 있다. 

#### 서브클래싱과 서브타이핑
#### 언제 상속을 해야 하는가?
- 상속관계가 is-a 관계를 모델링 하는가?
	- 자식클래스는 부모클래스다 말해도 이상하지 않는가
- 클라이언트 입장에서 부모 클래스의 타입으로 자식클래스를 사용해도 무방한가 
	- 클라이언트는 자식클래스와 부모클래스의 차이를 몰라야 한다. -> 행동호환성  
#### is-a 관계
- 두 클래스가 어휘적으로 is-a 관계를 모델링할 경우에만 상속을 사용 해야 한다.  (ex 객체지향 언어는 프로그래밍 언어이다.)
- 하지만 is-a 관계가 생각보다 직관적이고 명쾌한것은 아님 예를 들어 팽귄은 새다, 새는 날수 있다를 보면 펭귄은 날수없다!(행동이 다르다)
- 즉 is-a.보다는 행동 호환성이 더 중요하다 
###### 행동 호환성
- 개념적으로 연관성이 있다고 하더라도 행동에 연관성이 없다면 is-a관계를 사용하지 말아야 한다. 
- 행동의 호호나 여부를 판단하는 기준은 클라이언트의 관점. 클라이언트가 두 타입이 동일하게 행동 할 것이라고 기대한다면 두타입을 타입 계층으로 묶을 수 있다. 
###### 클라이언트의 기대에 따라 계층 분리하기 
- 클라이언트에 따라 인터페이스를 분리하면 변경에 대한 영향을 더 세밀하게 제어 할 수 있게 된다. 
- 클라이언트의 기대에 따라 인터페이스를 분리하는 설계 원칙을 인터페이스 분리 원칙 이라고 한다. 
##### 서브 클래싱과 서브 타이핑 
- 서브클래싱 : 다른 클래스의 코드르 재사용할 목적으로 상속을 사용하는 경우를 가리킨다. (구현상속, 클래스 상속)
- 서브타이핑: 타입 계층을 구성하기 위해 상속을 사용하는 경우를 가리킨다. (인터페이스 상속)
- 대체가능성 부모클래스에서 자식클래스로 대체하더라도 시스템이 문제없이 잘 동작할 것을 보장해야한다. 
#### 리스코프 치환 원칙 
--- 
- 서브타입은 그것의 기반 티입에 대해 대체 가능해야 한다. 
- 행동 호환성을 설계 원칙으로 정리한 것 
- 행동 호환성을 유지함으로써 부모 클래스를 대체할 수 있도록 구현된 상속 관계만을 서프타이핑이라고 불러야 한다. 
- 리스코프 치환 원칙 직사각형 is a. 정상각형 문제 (P.457 참고) 
- 정사각형은 직사각형이다 라는 직관이 설계에서는 맞지않음. 
###### 클라이언트와 대체 가능성 
- 어떤 모델의 유효성은 클라이언트의 관점 에서만 검증 가능하다. 
- 상속 관계는 클라이언트의 관점에서 자식 클래스가 부모 클래스르 대체할 수 있을 때만 올바르다. 
- 대체 가능성을 결정하는 것은 클라이언트다.
##### is-a 관계 다시 살펴 보기
- 클라이언트 관점에서 자식 클래스의 행동이 부모 클래스의 행동과 호환되지 않고 그로 인해 대체가 불가능하다면 어휘적으로 is-a라고 말할 수 있다고 하더라도 그 관계를 is-a라고 할 수 없다. is-a 관계는 클라이언트 관점에서만 is-a 일때만 참이다. 
###### 리스코프 치환 원칙은 유연한 설계의 기반이다. 
- 클라이언트 입장에서 퍼블릭 인터페이스의 행동 방식이 변경되지 않느다면 클라이언트의 코드를 수정하지 않고도 계속 황장해 나갈 수있다. 
#### 계약에 의한 설계와 서브 타이핑
----
- 클라이언트와 서버 사이의 협력을 의무와 이익으로 구성된 계약의 관점에서 표현하는 것을 계약에 의한 설계라고 부른다. 
- 계약에 의한 설계는 사전조건과 사후조건 클래스 불변식 세가지 요소로 구정 된다. 
	- 사전 조건 클라이언트가 정상적으로 메서드를 실행하기 위해 만족시켜야 하는것 
	- 메서드가 실행된 후에 서버가 클라이언트에게 보장해야하는 조건
	- 메서드 실행 전과 실행후에 인스턴스가 몬족시켜야하는 조건 
- 리스코프 치한원칙에 따르면 서브타입이 슈퍼타입처럼 보여야 함
- 서브타입이 슈퍼타입처러 보이려면 클라이언트가 슈퍼타입과 맺은 계약을 서브타입이 준수하는 것뿐이다. 
- 서브타입은 슈퍼타입보다 더 강력한 사전조건을 작성 할 수 없다. (약한 조건 가능)
- 서브타입은 슈퍼타입보다 더 강력한 사후조건을 작성 할 수 있다.(약한 조건 불가능)
## 🧰 주요 개념 / 핵심 내용 


## 🌟 인상 깊은 문장

## 💡 인사이트 / 느낀 점  

## ❓ 질문 / 더 알아볼 것 

## 📌 관련 링크 또는 참고 메모 


