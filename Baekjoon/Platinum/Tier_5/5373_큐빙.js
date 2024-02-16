const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

const rotateLeft = function (arr) {
  const newArr = [["", "", ""], ["", "", ""], ["", "", ""]];

  newArr[0][0] = arr[0][2];
  newArr[0][1] = arr[1][2];
  newArr[0][2] = arr[2][2];

  newArr[1][0] = arr[0][1];
  newArr[1][1] = arr[1][1];
  newArr[1][2] = arr[2][1];

  newArr[2][0] = arr[0][0];
  newArr[2][1] = arr[1][0];
  newArr[2][2] = arr[2][0];

  return newArr;
}

const rotateRight = function (arr) {
  const newArr = [["", "", ""], ["", "", ""], ["", "", ""]];

  newArr[0][0] = arr[2][0];
  newArr[0][1] = arr[1][0];
  newArr[0][2] = arr[0][0];

  newArr[1][0] = arr[2][1];
  newArr[1][1] = arr[1][1];
  newArr[1][2] = arr[0][1];

  newArr[2][0] = arr[2][2];
  newArr[2][1] = arr[1][2];
  newArr[2][2] = arr[0][2];

  return newArr;
}

const commands = {
  "U+": (cube) => {
    const temp = [cube[2][0][0], cube[2][0][1], cube[2][0][2]];

    cube[2][0][0] = cube[5][0][0];
    cube[2][0][1] = cube[5][0][1];
    cube[2][0][2] = cube[5][0][2];

    cube[5][0][0] = cube[3][2][2];
    cube[5][0][1] = cube[3][2][1];
    cube[5][0][2] = cube[3][2][0];

    cube[3][2][2] = cube[4][0][0];
    cube[3][2][1] = cube[4][0][1];
    cube[3][2][0] = cube[4][0][2];

    cube[4][0][0] = temp[0];
    cube[4][0][1] = temp[1];
    cube[4][0][2] = temp[2];

    cube[0] = rotateRight(cube[0]);
  },
  "U-": (cube) => {
    const temp = [cube[2][0][0], cube[2][0][1], cube[2][0][2]];

    cube[2][0][0] = cube[4][0][0];
    cube[2][0][1] = cube[4][0][1];
    cube[2][0][2] = cube[4][0][2];

    cube[4][0][0] = cube[3][2][2];
    cube[4][0][1] = cube[3][2][1];
    cube[4][0][2] = cube[3][2][0];

    cube[3][2][2] = cube[5][0][0];
    cube[3][2][1] = cube[5][0][1];
    cube[3][2][0] = cube[5][0][2];

    cube[5][0][0] = temp[0];
    cube[5][0][1] = temp[1];
    cube[5][0][2] = temp[2];

    cube[0] = rotateLeft(cube[0]);
  },
  "D+": (cube) => {
    const temp = [cube[2][2][0], cube[2][2][1], cube[2][2][2]];

    cube[2][2][0] = cube[4][2][0];
    cube[2][2][1] = cube[4][2][1];
    cube[2][2][2] = cube[4][2][2];

    cube[4][2][0] = cube[3][0][2];
    cube[4][2][1] = cube[3][0][1];
    cube[4][2][2] = cube[3][0][0];

    cube[3][0][2] = cube[5][2][0];
    cube[3][0][1] = cube[5][2][1];
    cube[3][0][0] = cube[5][2][2];

    cube[5][2][0] = temp[0];
    cube[5][2][1] = temp[1];
    cube[5][2][2] = temp[2];

    cube[1] = rotateRight(cube[1]);
  },
  "D-": (cube) => {
    const temp = [cube[2][2][0], cube[2][2][1], cube[2][2][2]];

    cube[2][2][0] = cube[5][2][0];
    cube[2][2][1] = cube[5][2][1];
    cube[2][2][2] = cube[5][2][2];

    cube[5][2][0] = cube[3][0][2];
    cube[5][2][1] = cube[3][0][1];
    cube[5][2][2] = cube[3][0][0];

    cube[3][0][2] = cube[4][2][0];
    cube[3][0][1] = cube[4][2][1];
    cube[3][0][0] = cube[4][2][2];

    cube[4][2][0] = temp[0];
    cube[4][2][1] = temp[1];
    cube[4][2][2] = temp[2];

    cube[1] = rotateLeft(cube[1]);
  },
  "F+": (cube) => {
    const temp = [cube[0][2][0], cube[0][2][1], cube[0][2][2]];

    cube[0][2][0] = cube[4][2][2];
    cube[0][2][1] = cube[4][1][2];
    cube[0][2][2] = cube[4][0][2];

    cube[4][0][2] = cube[1][0][0];
    cube[4][1][2] = cube[1][0][1];
    cube[4][2][2] = cube[1][0][2];

    cube[1][0][0] = cube[5][2][0];
    cube[1][0][1] = cube[5][1][0];
    cube[1][0][2] = cube[5][0][0];

    cube[5][0][0] = temp[0];
    cube[5][1][0] = temp[1];
    cube[5][2][0] = temp[2];

    cube[2] = rotateRight(cube[2]);
  },
  "F-": (cube) => {
    const temp = [cube[0][2][0], cube[0][2][1], cube[0][2][2]];

    cube[0][2][0] = cube[5][0][0];
    cube[0][2][1] = cube[5][1][0];
    cube[0][2][2] = cube[5][2][0];

    cube[5][0][0] = cube[1][0][2];
    cube[5][1][0] = cube[1][0][1];
    cube[5][2][0] = cube[1][0][0];

    cube[1][0][0] = cube[4][0][2];
    cube[1][0][1] = cube[4][1][2];
    cube[1][0][2] = cube[4][2][2];

    cube[4][0][2] = temp[2];
    cube[4][1][2] = temp[1];
    cube[4][2][2] = temp[0];

    cube[2] = rotateLeft(cube[2]);
  },
  "B+": (cube) => {
    const temp = [cube[0][0][0], cube[0][0][1], cube[0][0][2]];

    cube[0][0][0] = cube[5][0][2];
    cube[0][0][1] = cube[5][1][2];
    cube[0][0][2] = cube[5][2][2];

    cube[5][0][2] = cube[1][2][2];
    cube[5][1][2] = cube[1][2][1];
    cube[5][2][2] = cube[1][2][0];

    cube[1][2][0] = cube[4][0][0];
    cube[1][2][1] = cube[4][1][0];
    cube[1][2][2] = cube[4][2][0];

    cube[4][0][0] = temp[2];
    cube[4][1][0] = temp[1];
    cube[4][2][0] = temp[0];

    cube[3] = rotateRight(cube[3]);
  },
  "B-": (cube) => {
    const temp = [cube[0][0][0], cube[0][0][1], cube[0][0][2]];

    cube[0][0][0] = cube[4][2][0];
    cube[0][0][1] = cube[4][1][0];
    cube[0][0][2] = cube[4][0][0];

    cube[4][0][0] = cube[1][2][0];
    cube[4][1][0] = cube[1][2][1];
    cube[4][2][0] = cube[1][2][2];

    cube[1][2][0] = cube[5][2][2];
    cube[1][2][1] = cube[5][1][2];
    cube[1][2][2] = cube[5][0][2];

    cube[5][0][2] = temp[0];
    cube[5][1][2] = temp[1];
    cube[5][2][2] = temp[2];

    cube[3] = rotateLeft(cube[3]);
  },
  "L+": (cube) => {
    const temp = [cube[0][0][0], cube[0][1][0], cube[0][2][0]];

    cube[0][0][0] = cube[3][0][0];
    cube[0][1][0] = cube[3][1][0];
    cube[0][2][0] = cube[3][2][0];

    cube[3][0][0] = cube[1][0][0];
    cube[3][1][0] = cube[1][1][0];
    cube[3][2][0] = cube[1][2][0];

    cube[1][0][0] = cube[2][0][0];
    cube[1][1][0] = cube[2][1][0];
    cube[1][2][0] = cube[2][2][0];

    cube[2][0][0] = temp[0];
    cube[2][1][0] = temp[1];
    cube[2][2][0] = temp[2];

    cube[4] = rotateRight(cube[4]);
  },
  "L-": (cube) => {
    const temp = [cube[0][0][0], cube[0][1][0], cube[0][2][0]];

    cube[0][0][0] = cube[2][0][0];
    cube[0][1][0] = cube[2][1][0];
    cube[0][2][0] = cube[2][2][0];

    cube[2][0][0] = cube[1][0][0];
    cube[2][1][0] = cube[1][1][0];
    cube[2][2][0] = cube[1][2][0];

    cube[1][0][0] = cube[3][0][0];
    cube[1][1][0] = cube[3][1][0];
    cube[1][2][0] = cube[3][2][0];

    cube[3][0][0] = temp[0];
    cube[3][1][0] = temp[1];
    cube[3][2][0] = temp[2];

    cube[4] = rotateLeft(cube[4]);
  },
  "R+": (cube) => {
    const temp = [cube[0][0][2], cube[0][1][2], cube[0][2][2]];

    cube[0][0][2] = cube[2][0][2];
    cube[0][1][2] = cube[2][1][2];
    cube[0][2][2] = cube[2][2][2];

    cube[2][0][2] = cube[1][0][2];
    cube[2][1][2] = cube[1][1][2];
    cube[2][2][2] = cube[1][2][2];

    cube[1][0][2] = cube[3][0][2];
    cube[1][1][2] = cube[3][1][2];
    cube[1][2][2] = cube[3][2][2];

    cube[3][0][2] = temp[0];
    cube[3][1][2] = temp[1];
    cube[3][2][2] = temp[2];

    cube[5] = rotateRight(cube[5]);
  },
  "R-": (cube) => {
    const temp = [cube[0][0][2], cube[0][1][2], cube[0][2][2]];

    cube[0][0][2] = cube[3][0][2];
    cube[0][1][2] = cube[3][1][2];
    cube[0][2][2] = cube[3][2][2];

    cube[3][0][2] = cube[1][0][2];
    cube[3][1][2] = cube[1][1][2];
    cube[3][2][2] = cube[1][2][2];

    cube[1][0][2] = cube[2][0][2];
    cube[1][1][2] = cube[2][1][2];
    cube[1][2][2] = cube[2][2][2];

    cube[2][0][2] = temp[0];
    cube[2][1][2] = temp[1];
    cube[2][2][2] = temp[2];

    cube[5] = rotateLeft(cube[5]);
  }
}

readline
  .on('line', (line) => {
    input.push(line);
  })
  .on('close', () => {
    const T = parseInt(input[0]);

    for (let index = 1; index <= T; index++) {
      const cube = [
        [
          ['w', 'w', 'w'],
          ['w', 'w', 'w'],
          ['w', 'w', 'w']
        ],
        [
          ['y', 'y', 'y'],
          ['y', 'y', 'y'],
          ['y', 'y', 'y']
        ],
        [
          ['r', 'r', 'r'],
          ['r', 'r', 'r'],
          ['r', 'r', 'r']
        ],
        [
          ['o', 'o', 'o'],
          ['o', 'o', 'o'],
          ['o', 'o', 'o']
        ],
        [
          ['g', 'g', 'g'],
          ['g', 'g', 'g'],
          ['g', 'g', 'g']
        ],
        [
          ['b', 'b', 'b'],
          ['b', 'b', 'b'],
          ['b', 'b', 'b']
        ]
      ]

      const rotates = input[index + index].split(" ");

      for (let i = 0; i < rotates.length; i++) {
        commands[rotates[i]](cube);
      }

      for (let i = 0; i < 3; i++) {
        console.log(`${cube[0][i][0]}${cube[0][i][1]}${cube[0][i][2]}`);
      }
    }

    process.exit();
  });
