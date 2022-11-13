class Tree:
    def __init__(self):
        self.count = {}
        self.nextNode = {}

    def generateTree(self, word):
        currentNode = self

        for char in word:
            currentNode.count.setdefault(len(word), 0)
            currentNode.count[len(word)] += 1
            nextNode = Tree()

            if char in currentNode.nextNode:
                nextNode = currentNode.nextNode.get(char)
            else:
                currentNode.nextNode[char] = nextNode

            currentNode = nextNode

        return self

    def searchTree(self, query):
        currentNode = self

        for char in query:
            if char == '?':
                return currentNode.count.get(len(query), 0)

            if char in currentNode.nextNode:
                currentNode  = currentNode.nextNode[char]
            else:
                return 0

        return currentNode.count.get(len(query))


def solution(words, queries):
    answer = []

    trie = Tree()
    trie_reversed = Tree()

    for word in words:
        trie.generateTree(word)
        trie_reversed.generateTree(word[::-1])

    for query in queries:
        answer.append(trie.searchTree(query) if query[-1] == '?' else trie_reversed.searchTree(query[::-1]))

    return answer
