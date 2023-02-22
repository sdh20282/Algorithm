function solution(n) {
    const pibo = Array(n).fill(0)
    pibo[0] = 1;
    pibo[1] = 2;
    
    for(let i = 2; i < n; i++){
        if ((pibo[i-1] + pibo[i-2]) > 1000000007) {
            pibo[i] = (pibo[i-1] + pibo[i-2]) % 1000000007;
            continue;
        }
        
        pibo[i] = (pibo[i-1] + pibo[i-2])
    }
    
    return pibo[n-1];
}
