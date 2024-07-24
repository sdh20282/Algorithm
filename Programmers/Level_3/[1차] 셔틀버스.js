const toTimeNumber = (time) => {
  const times = time.split(':');

  return times[0] * 60 + parseInt(times[1]);
}

const toTimeString = (time) => {
  const hour = Math.floor(time / 60);
  const minute = time % 60;

  return `${hour < 10 ? `0${hour}` : `${hour}`}:${minute < 10 ? `0${minute}` : `${minute}`}`;
}

function solution(n, t, m, timetable) {
  const crews = [...timetable.map(time => toTimeNumber(time))].sort((a, b) => a - b);

  let depart = 540;
  let crewIdx = 0;

  for (let i = 0; i < n - 1; i++) {
    for (let _ = 0; _ < m; _++) {
      if (crewIdx < crews.length && crews[crewIdx] <= depart) {
        crewIdx += 1;
      } else {
        break;
      }
    }

    depart += t;
  }

  return crews.length - crewIdx < m || crews[crewIdx + m - 1] > depart ? toTimeString(depart) : toTimeString(crews[crewIdx + m - 1] - 1);
}
