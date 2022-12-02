# DisperseAiGUI

## Summary ☀

This project will help detect the quantity of big crowds(generally above 100 people). A user can use this program to easily check a general quantity of a crowd within seconds. For organizations or events, This information can be relayed to an official who could help disperse a crowd. There is no training required to use this program and minimal setup. Using this program on images with less than 100 people will result in less accurate results. 😎


## Requirements 📃

- Windows Operating System
- Python 3.7
- Java (19)
  - Windows Builder Library   
- Anaconda
- List of packages:

|Package |                              Version|
|---------------------------------- |-----------|
|configparser    |                   4.0.2|
decorator               |           4.4.2|
future                   |          0.18.2|
futures                   |         3.3.0|
h5py                       |        2.10.0|
ipykernel                   |       4.10.1|
ipython                    |        5.10.0|
ipython-genutils           |        0.2.0|
ipywidgets                 |        7.7.1|
matplotlib                 |        2.2.5|
numpy                      |        1.16.6|
opencv-contrib-python      |        4.2.0.32|
Pillow                     |        6.2.2|
pip                        |        20.3.4|
pyparsing                  |        2.4.7|
scipy                      |        1.2.3|
scikit-image       		     |        0.14.5|
torch                      |        1.4.0|
torchvision                |        0.5.0|
tornado                    |        5.1.1|
wheel                      |        0.37.1|


## Set Up

- git clone https://github.com/vnmendoza/DisperseAiGUI/tree/alexa
- Download the [Model](https://drive.google.com/file/d/1AUDSIoArx00xqM3KldPETNhwVW0JXSQE/view?usp=share_link) 
- Edit the paths in `MainFrame.java` to your computer paths
- Run the GUI
- Click on `Upload JPG`
  - Select jpg with large crowd
  - Click on `Process Image`
- Wait (around 40 seconds) and then the denisty map will appear in a secondary screen

