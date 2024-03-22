function solution(plans) {
  for (const plan of plans) {
    const [hour, minute] = plan[1].split(":").map(Number);

    plan[1] = hour * 60 + minute;
    plan[2] = parseInt(plan[2]);
  }

  plans.sort((a, b) => a[1] - b[1]);

  const stack = [];
  const answer = [];
  let prev = plans[0];
  let time = prev[1];

  for (let i = 1; i < plans.length; i++) {
    const [curSubject, curStart, curDuration] = plans[i];

    if (time + prev[2] <= curStart) {
      answer.push(prev[0]);

      let leftTime = curStart - (time + prev[2]);

      while (stack.length !== 0) {
        const [subject, left] = stack.pop();

        if (left <= leftTime) {
          leftTime -= left;
          answer.push(subject);
        } else {
          stack.push([subject, left - leftTime]);

          break;
        }
      }
    }

    else {
      stack.push([prev[0], time + prev[2] - curStart]);
    }

    time = curStart;
    prev = [curSubject, curStart, curDuration];
  }

  answer.push(plans[plans.length - 1][0]);

  while (stack.length !== 0) {
    answer.push(stack.pop()[0]);
  }

  return answer;
}
