# Campus
CS201 BK project #2  
   
### Reminder for development
- this reminder should be delete after release   
    <br><br/>
- the smallest unit of position is 1m
    - the block of each tile is 1m*1m
    - the offset of map ```mp_offset``` represents the offset in tiles and also equals to the offest in meters
    - the size of map ```mp_size``` represents the counts in tiles and also equals to the size in meters
    <br><br/>
    - the starting point of map is its left-top corner rather than its center (y axis is inverted)
    <br><br/>
    - the positions of player and npcs are also in meters, so there should not be decimals
      - but as for the animations, ```p_pos``` may allows non-integer position exists temporarily   
    <br><br/>
- To do list:
    - [x] map reading [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
    <br><br/>
    - [ ] map rendering [@Najo0116](https://github.com/Najo0116)
      - [ ] multi-map rendering [@Najo0116](https://github.com/Najo0116)
      - [ ] adaptive details
    <br><br/>  
    - [ ] character rendering [@Najo0116](https://github.com/Najo0116)
    <br><br/> 
    - [x] key-mouse input [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
      - Using StdDraw?
      - [ ] player movement [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
      - [ ] interaction
        - [ ] time related
      - [ ] quit/reset
    <br><br/>
    - [ ] animation
      - [ ] ease in / ease out [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
      - [ ] smooth camera movement
  
    - [ ] Textures [@seanpushu](https://github.com/seanpushu)
