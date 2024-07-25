const rotate = (arr) => {
  const newArr = new Array(arr.length).fill(0).map(_ => new Array(arr.length).fill(-1));

  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      newArr[j][arr.length - 1 - i] = arr[i][j];
    }
  }

  return newArr;
}

const match = (map, start, size) => {
  for (let i = start; i < start + size; i++) {
    for (let j = start; j < start + size; j++) {
      if (!map[i][j]) {
        return false;
      }
    }
  }

  return true;
}

function solution(key, lock) {
  const map = new Array(lock.length + key.length + key.length).fill(0).map(_ => new Array(lock.length + key.length + key.length).fill(0));

  for (let i = key.length; i < key.length + lock.length; i++) {
    for (let j = key.length; j < key.length + lock.length; j++) {
      map[i][j] = lock[i - key.length][j - key.length];
    }
  }

  for (let _ = 0; _ < 4; _++) {
    key = rotate(key);

    for (let i = 0; i <= key.length + lock.length; i++) {
      for (let j = 0; j <= key.length + lock.length; j++) {
        const nowMap = [];

        for (let k = 0; k < map.length; k++) {
          nowMap.push([...map[k]]);
        }

        for (let r = 0; r < key.length; r++) {
          for (let c = 0; c < key.length; c++) {
            nowMap[i + r][j + c] = nowMap[i + r][j + c] === key[r][c] ? 0 : 1;
          }
        }

        if (match(nowMap, key.length, lock.length)) return true;
      }
    }
  }

  return false;
}
