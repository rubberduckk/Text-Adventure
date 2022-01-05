# Text-Adventure
Pilot Project: Adventure from _O1_ (link: <https://plus.cs.aalto.fi/o1/2020/w09/ch01/>)   
   
   
## :sparkles: Newly Added Features
### :bulb: new Area: ***Mystic Forest***

  ***Mystic Forest(MF)*** 구역이 새로 추가됩니다.   
  이 숲은 사람들 사이에서는 `northForest` 너머의 깊숙한 곳에 있다고 알려져 있습니다.

  큰 문제는, 이 숲을 나갈 수 있는 마땅한 출구가 존재하지 않는다는 것입니다. 여타 구역 간 이동에 사용되던 `go` 명령은 ***MF***에서는 유효하지 않습니다. 대신 이 곳에 살고 있는 신비로운 존재의 도움을 받아 다른 곳으로 이동할 수 있습니다.   
     
     
### :bulb: new Item: Wing

  ***MF*** 내부에 새로운 아이템 ***Wing***이 추가됩니다.   
  ***Wing***은 현재 플레이어가 위치한 곳에서 곧장 `home`으로 이동할 수 있도록 도와줍니다. 

   이 아이템은 다른 아이템과는 다르게, 분명히 ***MF***에 존재하지만 플레이어가 얻지 못할 수도 있습니다(20% 확률로 출현). 그러나  ***Wing***은 플레이어가 성공적으로 게임을 완수하는 데 꼭 필요한 요소가 아니기 때문에, 가지지 못해도 게임 진행에 큰 지장을 주지는 않습니다.   


### :bulb: new NPC: Wise Witch

  ___Wise Witch(WW)___ 는 플레이어가 이 게임을 빠른 시간 내에 성공할 수 있도록 도와줍니다. 

- 만약 플레이어가 `battery`와 `remote`를 모두 가지고 있는 상태라면, ***WW***는 플레이어의 위치를 곧바로 `home`으로 이동시켜 줍니다.
- 플레이어가 `battery`와 `remote` 중 하나만 가지고 있는 경우, 찾아야 할 물품이 있는 곳으로 위치를 이동시켜 줍니다.
- 혹시라도 둘 다 가지고 있지 않은 경우, `battery` 혹은 `remote`가 있는 위치 중 한 곳으로 랜덤하게 이동시킵니다.
