# 알고리즘 11주차 과제
* Prim Algorithm - MinHeap을 통해 키 값이 가장 작은 Vertex 선택 후 연결된 정점의 키 값보다 가중치가 작은 것의 키 값과 부모를 갱신
* 부모 Vertex와 부모 Vertex에서 해당 Vertex에 도달하는데 걸리는 비용 출력
* Kruskal Algorithm - 간선의 가중치를 기준으로 오름차순 정렬 후 모든 간선의 구성 정점들을 대상으로 Set 비교 및 다르면 union 및 간선 저장
* 부모 Vertex와 부모 Vertex에서 해당 Vertex에 도달하는데 걸리는 비용 출력
* Dijkstra Algorithm - MinHeap을 통해 거리가 가장 짧은 Vertex추출 해당 Vertex를 방문했다고 표시하고 그 Vertex와 연결된 간선으로 거리 갱신 수행
* 시작 정점부터 해당 정점까지의 가장 짧은 가중치를 가지는 동선과 거리 출력
* Bellman-Ford Algorithm - 모든 간선을 순회하며 거리 갱신 반복을 전체 정점 수 -1만큼 수행한다
* 시작 정점부터 해당 정점까지의 가장 짧은 가중치를 가지는 동선과 거리 출력
