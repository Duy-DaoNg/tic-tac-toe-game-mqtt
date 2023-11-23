## How To Run
Follow these line below to run this project
### 1. Clone the project

```bash
  git clone https://github.com/Duy-DaoNg/tic-tac-toe-game-mqtt.git
```

### 2. Go to the project directory

```bash
  cd tic-tac-toe-game-mqtt
```

### 3. Run command to start server
Using Git Bash on a WinOS, run this command:
```bash
  docker run -dp 8883:8883 --name tic-tac-toe-container -v "$(pwd):/app" duydaong/tic-tac-toe-game:latest

```
