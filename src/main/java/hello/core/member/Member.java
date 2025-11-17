package hello.core.member;

public class Member {

    private long id;
    private String name;
    private Grade grade;

    public Member(long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}

/* getter/setter를 쓰는 이유

public class Member {
    private long id;   // 외부 접근 차단
    private String name;

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter (읽기 전용)
    public long getId() {
        return id;
    }

    // Setter (쓰기 가능, 하지만 규칙을 줄 수 있음)
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비워둘 수 없습니다.");
        }
        this.name = name;
    }
}



**외부에서 사용할 때

* public class Main {
    public static void main(String[] args) {
        Member member = new Member(1L, "승기");

        // ID는 읽기만 가능
        System.out.println(member.getId()); // 1

        // 이름은 setter로만 변경 가능 (검증 포함)
        member.setName("철수");
        System.out.println(member.getId() + " / " + member.getName());
    }
}

정리

그냥 long id; → 외부에서 막 접근 가능 → 객체 규칙 깨질 위험 ↑

private long id; + Getter/Setter → 외부에서 직접 접근 불가 → 안전하게 관리 가능

Getter → 읽기만 허용

Setter → 쓰기를 허용하되, 유효성 검사 로직 넣을 수 있음
*/


