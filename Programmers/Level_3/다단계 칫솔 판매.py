def solution(enrolls, referrals, sellers, amounts):
    multistage = {}

    for enroll, referral in zip(enrolls, referrals):
        person_data = multistage.get(enroll, [])
        person_data.append(referral)
        person_data.append(0)
        multistage[enroll] = person_data

    for seller, amount in zip(sellers, amounts):
        amount *= 100

        while amount != 0 and seller != '-':
            person_data = multistage.get(seller)
            person_data[1] += amount - amount//10
            multistage[seller] = person_data

            amount = amount//10
            seller = person_data[0]

    answer = []

    for enroll in enrolls:
        answer.append(multistage[enroll][1])

    return answer
