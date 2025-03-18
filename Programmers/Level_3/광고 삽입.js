function stringToTime(time) {
  const [hour, minute, second] = time.split(":").map(Number);

  return hour * 3600 + minute * 60 + second;
}

function timeToString(sec) {
  const hour = String(Math.floor(sec / 3600)).padStart(2, '0');
  sec = sec % 3600;

  const minute = String(Math.floor(sec / 60)).padStart(2, '0');
  sec = sec % 60;

  const second = String(sec).padStart(2, '0');

  return `${hour}:${minute}:${second}`;
}

function solution(play_time, adv_time, logs) {
  let max = stringToTime(play_time);
  let times = new Array(max + 1).fill(0);

  for (let log of logs) {
    let [start, end] = log.split('-').map(stringToTime);

    times[start]++;
    times[end]--;
  }

  for (let i = 1; i <= max; i++) {
    times[i] += times[i - 1];
  }

  for (let i = 1; i <= max; i++) {
    times[i] += times[i - 1];
  }

  let advTime = stringToTime(adv_time);
  let result = -1;
  let startTime = -1;

  for (let i = 0; i + advTime - 1 <= max; i++) {
    let count = times[i + advTime - 1] - (i ? times[i - 1] : 0);

    if (count <= result) {
      continue;
    }

    result = count;
    startTime = i;
  }

  return timeToString(startTime);
}
