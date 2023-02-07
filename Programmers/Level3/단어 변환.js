function solution(begin, target, words) {
    // 타겟 단어가 단어 배열 안에 없을 경우 종료
    if (words.indexOf(target) == -1) {
        return 0;
    }

    // 두 단어를 비교하는 함수
    // 단어의 철자가 다른 개수를 반환
    const compareString = (origin, target) => {
        let diff = 0;

        for (let index = 0; index < origin.length; index++) {
            if (origin[index] != target[index]) {
                diff += 1;
            }
        }

        return diff;
    }

    // 탐색을 위한 큐
    const q = [];
    // 최소값 비교를 위한 변수
    let min = Number.MAX_SAFE_INTEGER;

    // 큐의 초기 값 설정
    // 입력 받은 단어들을 순회하며 origin 단어와 1글자가 다른 단어들을 큐에 push
    for (const word of words) {
        // 철자 비교 결과 1개만 다를 경우를 제외하고 continue
        if (compareString(begin, word) != 1) {
            continue;
        }
        
        // 방문 여부를 확인하기 위한 object
        const selected = {};

        // 해당 단어를 방문했다고 표시
        selected[word] = true;
        // 큐에 push
        q.push([word, selected, 1])
    }

    // 큐에 데이터가 존재하는 동안 반복
    while (q.length > 0) {
        // 전개구문을 통해 데이터를 가져옴
        const [nowWord, nowSelected, nowCount] = q.pop();

        // target 단어에 도달했을 경우
        // 카운트를 비교하여 더 작은 카운트 설정
        if (nowWord == target && nowCount < min) {
            min = nowCount;
            continue;
        }

        // 주어진 단어들에 대해
        for (const word of words) {
            // 같은 단어일 경우 생략
            if (nowWord == word) {
                continue;
            }

            // 방문한 단어일 경우 생략
            if (!!nowSelected[word] != false) {
                continue;
            }

            // 철자 1개만 다를 경우 제외하고 생략
            if (compareString(nowWord, word) != 1) {
                continue;
            }
    
            // 방문여부를 복사
            const nextSelected = {...nowSelected};
            // 선택된 단어를 방문했다고 표시
            nextSelected[word] = true;

            // 다음 단어와 해당하는 방문여부, 1회 증가된 횟수를 큐에 push
            q.push([word, nextSelected, nowCount + 1])
        }
    }

    // 최소값 반환
    return min;
}
