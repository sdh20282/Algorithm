function solution(skill, skill_trees) {
    let count = 0;

    for (const skill_tree of skill_trees) {
        count += skill_tree.split('').filter((x) => skill.includes(x)).map((x) => skill.indexOf(x)).map((value, index) => value === index ? true : false).includes(false) ? 0 : 1;
    }

    return count;
}
