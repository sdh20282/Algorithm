function solution(cap, n, deliveries, pickups) {
  let deliveryPointer = n - 1;
  let pickupPointer = n - 1;
  let distance = 0;

  const move = (arr, index, cap) => {
    if (index < 0) {
      return -1;
    }

    while (arr[index] === 0 && index >= 0) {
      index -= 1;
    }

    for (let i = index; (i >= 0 && cap > 0); 1) {
      if (arr[i] === 0) {
        while (arr[i] === 0 && i >= 0) {
          i -= 1;
        }
      } else {
        arr[i] -= 1;
        cap -= 1;
      }
    }

    return index;
  }

  while (1) {
    if (deliveryPointer < 0 && pickupPointer < 0) {
      break;
    }

    deliveryPointer = move(deliveries, deliveryPointer, cap);
    pickupPointer = move(pickups, pickupPointer, cap);

    distance += Math.max((deliveryPointer + 1), (pickupPointer + 1)) * 2;
  }

  return distance;
}
