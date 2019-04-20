# CS349 A3

Student: x46yan
Marker: Jay Henderson


Total: 100 / 100 (100.00%)

Code:
(CO: won’t compile, CR: crashes, FR: UI freezes/unresponsive, NS: not submitted)


Notes: ``

# A3 Marking Scheme

## General

[10/10] Interface displays, and includes required functionality.

When first launched, the application shows an empty window. The user can click on the "load" icon on the toolbar to display a File Chooser dialog, where they can select one or more images to load.



## 20% Load and view images and metadata.

[10/10] 2. When loaded, image thumbnails will be displayed in a grid or list, and sized appropriately to the width of the window (see Supported Layouts, below). Metadata for each image will also be shown, including at a minimum, file creation date and file name.



[5/5] 3. Clicking on an image should enlarge it in a separate window. You may choose the size of this window; it does not need to be resizable, and should not be larger than 800x600. You should also provide a mechanism to dismiss this window.



[5/5] 4. When exiting the application, it should save the list of images, so that on relaunch, the same images are automatically shown.


## 15% Rank images, filter based on ranking.

5.  [7/7] You should create a custom control that allows users to specify a rating for an image (indicated by the number of stars, ranging from 1 to 5). Users can rate each image by selecting the number of stars to assign to that image. You must also provide a mechanism to clear the rating for a specific photo, and a method to clear the display filter (i.e. return to showing all-images).



6.  [8/8] A filter widget on the toolbar allows the user to filter the display to just show images that have a minimum rating (e.g. clicking the 3-star search filter will show images with 3, 4, or 5 stars).



## 15% Grid and list layouts supported

[5/5] Switch between layouts



[5/5] List layout: In List Layout, only one item is shown in a row, meta data and ratings are shown right to each thumbnail.


[5/5] Grid layout: In Grid Layout, images are displayed in grids, meta data and ratings are shown below each thumbnail.



## 10% Resizing handled appropriately based on layout.

Your application should adjust its contents based on the size of the window\. More specifically, you should use Layout Managers to ensure that the number of columns shrinks or grows based on the available space\. This behaviour is different based on the layout selected:

[5/5] Grid Layout
The grid layout should adjust based on the size of the screen, so that columns wrap as needed.
Metadata should be displayed below the image, regardless of the number of columns being displayed


[5/5] List Layout Resizing

The list layout can remain unchanged, since everything is already in a column! Just make sure that you can't resize the window smaller than the width of the column.
In no case, should a horizontal scrollbar appear



## 25% MVC architecture properly realized.

[25/25] Your application must realize the Model-View-Controller architecture as described in class: you must have at least one distinct model, and at least two views. You may use IViews, or the Java Observer interface.



## Deliverables

[5/5] Deliverables: Appropriate project files and readme.txt. Code compiles and runs.

