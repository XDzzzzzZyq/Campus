# Campus
CS201 BK project #2  

https://whimsical.com/campus-UcuTaLE2NjuLUw6qSfXNG1

### press W A S D to move
![image](https://user-images.githubusercontent.com/81028185/220802233-1009e87f-0f71-40b1-8866-138625c22508.png)

### press E to enter to the buildings
![image](https://user-images.githubusercontent.com/81028185/220802284-daf894ba-fca9-4d95-ac44-8bf8228a9f32.png)

   
## notes
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
## development contributions
- To do list:
    - [x] map reading [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
    <br><br/>
    - [x] map rendering [@Najo0116](https://github.com/Najo0116) [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
      - [x] multi-map rendering [@Najo0116](https://github.com/Najo0116) [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
      - [ ] adaptive details
      - [x] random details [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
    <br><br/>  
    - [x] character rendering [@Najo0116](https://github.com/Najo0116) [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
    <br><br/> 
    - [x] key-mouse input [@Najo0116](https://github.com/Najo0116) [@XDzzzzzZyq](https://github.com/XDzzzzzZyq) 
      - Jframe [@Najo0116](https://github.com/Najo0116)
      - [x] player movement [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
      - [x] interaction [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
        - [ ] time related
      - [ ] quit/reset
      - [x] bounding detact [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
    <br><br/>
    - [x] animation
      - [x] ease in / ease out [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
      - [x] smooth camera movement [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
      - [x] step animation [@XDzzzzzZyq](https://github.com/XDzzzzzZyq)
  
    - [x] Textures [@XDzzzzzZyq](https://github.com/XDzzzzzZyq) [@seanpushu](https://github.com/seanpushu)
    - [x] Player textures [@Najo0116](https://github.com/Najo0116)
