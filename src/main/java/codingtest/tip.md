// 1. 기본형 내림차순
Collections.sort(arr, Collections.reverseOrder());

// 2. 기본형 오름차순  
Collections.sort(arr);

// 3. 커스텀 클래스 (점수 내림)
students.sort((s1,s2) -> s2.score - s1.score);

// 4. 다중 조건 (점수내림 → 이름오름)
students.sort((s1,s2) -> s1.score != s2.score ? s2.score-s1.score : s1.name.compareTo(s2.name));
