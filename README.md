# camp-gson
Gson Thread-safe test

##### Branch 정보
+ feature-1.2.2 : Thread-safe 관련 Issue 테스트 브랜치
+ feature-2.3.1 : Thread-safe 관련 Issue 수정 확인 테스트 브랜치

---
##### Thread 관련 Issue 및 Release 정보

Version 1.2.3
- Made Gson thread-safe by fixing Issue 63
  + <a href="https://groups.google.com/forum/#!topic/google-gson/Vju1HuJJUIE" target="_blank">google-gson thread 관련 내용</a>
  + <a href="https://github.com/google/gson/issues/63" target="_blank">해당 문제사항에 대한 gson issue 내용</a>

Version 1.4 BETA
- Default date type adapter is now thread-safe. See Issue 162.
  + <a href="https://github.com/google/gson/issues/162" target="_blank">해당 문제사항에 대한 gson issue 내용</a>

Version 1.7.2
- Fixed a threading issue in FieldAttributes (Issue 354)
  + <a href="https://github.com/google/gson/issues/354" target="_blank">해당 문제사항에 대한 gson issue 내용</a>

---

##### 그 외 ..
+ <a href="https://github.com/google/gson/issues/613" target="_blank">Issue.613 Document that Gson instances are thread safe </a>

- Version 2.4 에서는 Gson.java Javadoc에 Thread-safe 관련 명시가 되어있습니다.
  + <a href="https://github.com/google/gson/commit/b4978a8062220ae431750d93f76d737e83a5bd89" target="_blank">Updated Gson Javadoc to indicate thread-safety.</a>

- feature-2.3.1 branch 테스트 케이스 및 Release 정보를 참조하면 관련 Thread-safe Issue는 처리가 되어있고, 현재 Version보다 상위 Version 2.4 의 Change log에 Thread 관련 변경 내용은 없었습니다.

---

###### <a href="https://github.com/inder123" target="_blank">Inderjeet Singh</a>
- <a href="https://github.com/google/gson/graphs/contributors" target="_blank">Gson Contributors</a>

- <a href="https://groups.google.com/forum/#!topicsearchin/google-gson/once$20create/google-gson/rhIJ4wi5IRE" target="_blank">Gson 인스턴스에 대한 성능 권장 사항</a>
```
cf. Gson Contributor가 과거에 작성한 성능 관련 Thread 일부 내용 번역 내용입니다. 

기본 serializers, deserializers 및 instance 생성해서 모두 등록을 하기 때문에 Gson을 생성하는 것은 다소 비싼 작업이다.
static final 생성자로 기본 list에 저장해 최적화를 시도했다. 
그것이 Gson을 어디에서 사용하든 동일한 instance를 재사용하는 최선이라 생각했기 때문이다.
```
