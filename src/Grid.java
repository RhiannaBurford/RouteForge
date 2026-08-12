import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
public class Grid extends JFrame {
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   ArrayList<Hold> Cat1Holds = new ArrayList<>();
   ArrayList<Hold> Cat2Holds = new ArrayList<>();
   ArrayList<Hold> Cat3Holds = new ArrayList<>();
   ArrayList<Hold> Cat4Holds = new ArrayList<>();
   ArrayList<Hold> Cat5Holds = new ArrayList<>();
   ArrayList<Hold> Cat6Holds = new ArrayList<>();
   ArrayList<Hold> Cat7Holds = new ArrayList<>();
   ArrayList<Hold> Cat8Holds = new ArrayList<>();
   ArrayList<Hold> Cat9Holds = new ArrayList<>();
   ArrayList<Hold> Cat10Holds = new ArrayList<>();
   private LinkedList<VolumeHold> usedVolumeHolds = new LinkedList<>();

   public Grid(int height, String incline, int difficulty) {
       setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
       setBounds(755, 175, 600, 600);
       int gridHeight = height * 6;
       int gridWidth = 7; // columns
       int labelSize = 75; // width and height of each box
       contentPane = new JPanel();
       contentPane.setBackground(new Color(255, 255, 255));
       contentPane.setLayout(new GridBagLayout());
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.fill = GridBagConstraints.BOTH;
       // Define hold arrays


       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/BlackBlockHold.jpg\\"));
       //Adding a hold with difficulty 2 and name "Black Block" to the category 2 array list
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/BlackGigaPocket.jpg\\"));
       //Adding a hold with difficulty 3 and name "Black Giga Pocket" to the category 3 array list
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/BlackMassivePocket.jpg\\"));
       //Adding a hold with difficulty 1 and name "Black Massive Pocket" to the category 1 array list
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/BlueBar.jpg\\"));
       //Adding a hold with difficulty 6 and name "Blue Bar" to the category 1 array list
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/BlueBlockHold.jpg\\"));
       Cat4Holds.add(new VolumeHold(4, "CS IA - Climbing Holds Images/BlueCaterpillar.jpg\\","Caterpillar","medium"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/BlueChunk.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/BlueCrimpDouble.jpg\\"));
       Cat4Holds.add(new Hold(2, "CS IA - Climbing Holds Images/BlueCrimpNegative.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/BlueCurveJug.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/BlueDadao.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/BlueDadaoCurve.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/BlueDadaoLarge.jpg\\"));
       //This process continues for 180 holds
       Cat9Holds.add(new Hold(8, "CS IA - Climbing Holds Images/BlueDadaoMorePositive.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/BlueDeerHornKnife.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/BlueDepressionSphere.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/BlueDividingThree.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/BlueDoublePocket.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/BlueDualHandSloper.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/BlueDualTexEdge.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/BlueDualTexPocket.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/BlueDualTexSloperLeft.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/BlueDualTexUnderclingPocket.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/BlueGigaPocket.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/BlueGraniteChumk.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/BlueGraniteJug.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/BlueGraniteSmallJug.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/BlueGraniteTriangle.jpg\\"));
       Cat7Holds.add(new VolumeHold(7, "CS IA - Climbing Holds Images/BlueLaGrattonade.jpg\\","La Grattonade","large"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/BlueLargeBulb.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/BlueLargeCrimp.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/BlueLargeEdge.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/BlueLargeSloper.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/BlueLeftBlock.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/BlueLeftJug.jpeg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/BlueLongChunk.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/BlueLongCrimp.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/BlueLongJug.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/BlueMaxSlopers.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/BlueMediumBulb.jpg\\"));
       Cat8Holds.add(new VolumeHold(8, "CS IA - Climbing Holds Images/BlueMegaDualHand.jpg","Mega Dual","large"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/BlueMegaRidge.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/BlueMiniPentagon.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/BlueNiceCrimp.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/BlueNiceEdge.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/BlueOuroborosLong.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/BluePartialJug.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/BluePartialJugMiddle.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/BlueLongChunk.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/BlueRailBar.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/BlueRoundedChunk.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/BlueRoundedUndercling.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/BlueSmallHold.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/BlueSmallJug.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/BlueThinPinch.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/BlueTiltedJug.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/BlueWedgeTwoBobble.png\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/GreenAverageSloper.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/GreenBarPinch.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/GreenBarPinch2.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/GreenClassicCrimp.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/GreenClassicJug.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/GreenDoubleCrimp.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/GreenDoubleJug.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/GreenDualHandEdge.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/GreenGigaPocket.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/GreenGraniteCrimp.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/GreenLargeAngleCrimp.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/GreenLargeDualHand.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/GreenLargeLowerCrimp.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/GreenLongJug.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/GreenMassiveJug.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/GreenOpenHandedJug.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/GreenPinchJug.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/GreenPocket.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/GreenPocketMedium.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/GreenPocketSmall.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/GreenPositivePinch.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/GreenSmallHold.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/GreenWoodenLeft.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/GreenWoodenTriangle.jpg\\"));
       Cat8Holds.add(new VolumeHold(8, "CS IA - Climbing Holds Images/LargeYellowFountaineBleau.png\\","Fountaine Bleau","medium"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/MauveJugLarge.jpeg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/MauveJugLargeLeft.jpeg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/orangeAngularCrimp.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/orangeAngularCrimpLarge.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/OrangeAngularVshapedcrimp.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/OrangeFlatPocket.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/OrangeLargePinch.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/OrangeLongPinch.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/OrangeMiniCrimp.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/OrangePetalPocket.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/OrangePetalPocketSloper.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/OrangePetalSloper.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/OrangePocket.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/OrangeRightPinch.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/OrangeTriangleSpire.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/OrangeTufa.jpg\\"));
       Cat9Holds.add(new VolumeHold(9, "CS IA - Climbing Holds Images/PurpleCoastalLarge.png\\","Coastal","medium"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/PurpleDualTextHand.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/PurpleDualTextJug.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/PurpleDualTextSmall.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/PurpleDualTextUndercling.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/PurpleDualTextUnderclingBad.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/PurpleFunSpot.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/PurpleGritstoneCrimp.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/PurpleGritstoneLong.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/PurpleGritstoneLongJug.jpg\\"));
       Cat8Holds.add(new Hold(9, "CS IA - Climbing Holds Images/PurpleGristonePocket.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/PurpleLongPinch.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/RedBeginnerJug.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/RedBlockHold.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/RedCrimp.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/RedCurvyElicaPinch.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/RedDoubleHandPinch.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/RedDualHandJug.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/RedDualHandPinch.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/RedGigaPocket.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/RedGoodstoneSmall.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/RedLargeBlock.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/RedLargeGranite.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/RedLargeGraniteEdge.jpg\\"));
       Cat9Holds.add(new VolumeHold(9, "CS IA - Climbing Holds Images/RedLargeGrit.png\\","Gritstone","large"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/RedLargeJug.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/RedLargeSteppenwolf.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/RedLargeWonderboy.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/RedLeftSloper.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/RedLongPinch.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/RedLSloper.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/RedMassivePocket.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/RedMediumJug.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/RedNegativeSloper.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/RedOrganicJugPocket.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/RedPinchSloper.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/RedPositiveSloper.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/RedRightAngle.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/RedRippleGranite.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/RedScissorPocket.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/RedSloperDualHanded.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/RedSmallCrimp.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/RedSmallHold.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/RedSmoothUndercling.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/RedStone.jpg\\"));
       Cat7Holds.add(new VolumeHold(7, "CS IA - Climbing Holds Images/WhiteLimestoneLarge.png\\","Limestone","medium"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/YellowBanana.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/YellowBlockLarge.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/YellowBrickPinchNice.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/YellowCheeseBlock.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/YellowCroissantUndercling.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/YellowDiamond.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/YellowDipDualHand.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/YellowDualHandJug.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/YellowDualTexPinch.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/YellowEarJug.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/YellowEarJug2.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/YellowEdgeTorture.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/YellowFlatCrimp.jpg\\"));
       Cat7Holds.add(new Hold(7, "CS IA - Climbing Holds Images/YellowFontFeature.jpg\\"));
       Cat5Holds.add(new Hold(5, "CS IA - Climbing Holds Images/YellowGeometricVolume.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/YellowJugCurve.jpg\\"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/YellowJugDualTexRight.jpg\\"));
       Cat1Holds.add(new Hold(1, "CS IA - Climbing Holds Images/YellowJugPinch.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/YellowKiteVolume.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/YellowLargeBulb.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/YellowLargeCroissant.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/YellowLargeDualTex.jpg\\"));
       Cat6Holds.add(new VolumeHold(6, "CS IA - Climbing Holds Images/YellowLargeTufa.jpg\\","Tufa","medium"));
       Cat2Holds.add(new Hold(2, "CS IA - Climbing Holds Images/YellowLimestoneCrimp.jpg\\"));
       Cat3Holds.add(new Hold(3, "CS IA - Climbing Holds Images/YellowLimestonePinch.jpg\\"));
       Cat10Holds.add(new Hold(10, "CS IA - Climbing Holds Images/YellowOneFingerPocket.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/YellowSlightEdge.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/YellowThinDadao.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/YellowThinDualTexEdge.jpg\\"));
       Cat6Holds.add(new Hold(6, "CS IA - Climbing Holds Images/YellowThreePocket.jpg\\"));
       Cat4Holds.add(new Hold(4, "CS IA - Climbing Holds Images/YellowTickVolume.jpg\\"));
       Cat8Holds.add(new Hold(8, "CS IA - Climbing Holds Images/YellowSlightEdge.jpg\\"));
       Cat9Holds.add(new Hold(9, "CS IA - Climbing Holds Images/YellowTriangle.jpg\\"));
       int[] SlabProb = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4};
       int[] VerticalProb = {0, 1, 1, 2, 2, 2, 2, 3, 3, 4};
       int[] OverhangProb = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3};
       int JumpRow = 0;
       for (int row = 0; row < gridHeight; row++) { // repeats for all boxes
           JLabel cell = new JLabel();
           cell.setOpaque(true);
           cell.setBackground(new Color(255, 255, 255)); // (White)
           cell.setBorder(new LineBorder(Color.WHITE, 1));
           cell.setHorizontalAlignment(SwingConstants.CENTER);
           cell.setVerticalAlignment(SwingConstants.CENTER);
           int RowRandom = (int) Math.floor(Math.random() * 10);
           int ColRandom = (int) Math.floor(Math.random() * 7);
           if (incline.equals("Slab")) {
               JumpRow = SlabProb[RowRandom];
           } else if (incline.equals("Vertical")) {
               JumpRow = VerticalProb[RowRandom];
           } else {
               JumpRow = OverhangProb[RowRandom];
           }
           ArrayList<Hold> AvailableHold = new ArrayList<>();
           int min = 0, max = 30;
   
           if (difficulty == 1) {
               //to create the available holds for the chosen difficulty
              	 AvailableHold.addAll(Cat1Holds);
              	 AvailableHold.addAll(Cat2Holds);
              	 max = 30;
              	 }
               else if (difficulty == 2) {
              	 AvailableHold.addAll(Cat1Holds);
              	 AvailableHold.addAll(Cat2Holds);
              	 AvailableHold.addAll(Cat3Holds);
              	 max = 49;
               }
               else if (difficulty == 3) {
              	 AvailableHold.addAll(Cat2Holds);
              	 AvailableHold.addAll(Cat3Holds);
              	 AvailableHold.addAll(Cat4Holds);
              	 max = 53;
               }
               else if (difficulty == 4) {
              	 AvailableHold.addAll(Cat3Holds);
              	 AvailableHold.addAll(Cat4Holds);
              	 AvailableHold.addAll(Cat5Holds);
              	 max = 54;
               }
               else if (difficulty == 5) {
              	 AvailableHold.addAll(Cat4Holds);
              	 AvailableHold.addAll(Cat5Holds);
              	 AvailableHold.addAll(Cat6Holds);
              	 max = 54;
               }
               else if (difficulty == 6) {
              	 AvailableHold.addAll(Cat5Holds);
              	 AvailableHold.addAll(Cat6Holds);
              	 AvailableHold.addAll(Cat7Holds);
              	 max = 56;
               }
               else if (difficulty == 7) {
              	 AvailableHold.addAll(Cat6Holds);
              	 AvailableHold.addAll(Cat7Holds);
              	 AvailableHold.addAll(Cat8Holds);
              	 max = 53;
               }
               else if (difficulty == 8) {
              	 AvailableHold.addAll(Cat7Holds);
              	 AvailableHold.addAll(Cat8Holds);
              	 AvailableHold.addAll(Cat9Holds);
              	 max = 55;
               }
               else if (difficulty == 9) {
              	 AvailableHold.addAll(Cat8Holds);
              	 AvailableHold.addAll(Cat9Holds);
              	 AvailableHold.addAll(Cat10Holds);
              	 max = 48;
               }
               else if (difficulty == 10) {
              	 AvailableHold.addAll(Cat9Holds);
              	 AvailableHold.addAll(Cat10Holds);
              	 max = 30;
               }
           // Select a random hold from available holds
           int Random = (int) Math.floor(Math.random() * (max - min + 1) + min);
           Hold selectHold = AvailableHold.get(Random);
           String imagePath = selectHold.getImagePath();
           ImageIcon icon = new ImageIcon(imagePath);
           Image img = icon.getImage();
           if (selectHold instanceof VolumeHold) {
        	    VolumeHold volumeHold = (VolumeHold) selectHold;
        	    usedVolumeHolds.add(volumeHold); // Track only volume holds used in this grid
        	}
           Image scaledImg = img.getScaledInstance(labelSize, labelSize, Image.SCALE_SMOOTH);
           cell.setIcon(new ImageIcon(scaledImg));
           cell.setPreferredSize(new Dimension(labelSize, labelSize));
           gbc.gridx = ColRandom;
           gbc.gridy = row;
           contentPane.add(cell, gbc);
           row += JumpRow;
       }
       JScrollPane scrollPane = new JScrollPane(contentPane);
       setContentPane(scrollPane);
       setPreferredSize(new Dimension(gridWidth * labelSize + 50, 600));
       pack();
   }
   // IMPORTANT FEATURE - CAPTURING THE WHOLE JFRAME AS AN IMAGE SO THAT IT CAN BE DOWNLOADED/SHARED
   
   public BufferedImage captureGridAsImage() {
       BufferedImage image = new BufferedImage(contentPane.getWidth(), contentPane.getHeight()
    		   , BufferedImage.TYPE_INT_ARGB);
       Graphics2D g2d = image.createGraphics();
       contentPane.printAll(g2d);
       g2d.dispose();
       return image;
   }
   public void saveVolumeHoldsInfoToFile(String filePath) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        // iterate through usedVolumeHolds list
	    	for (int i = 0;i<usedVolumeHolds.size();i++) { 
	    		VolumeHold volumeHold = usedVolumeHolds.get(i);
	    	    writer.write("Name: " + volumeHold.getName() + ", " + "Size: " + volumeHold.getSize());
	            writer.newLine();
	        }
	        System.out.println("Volume holds information saved to " + filePath);
	    } catch (IOException e) {
	        System.err.println("Error saving volume holds information: " + e.getMessage());
	    }
	}

   // Saving the imageas a file
   public void saveGridAsImageFile(String filePath) {
       BufferedImage image = captureGridAsImage();
       try {
           ImageIO.write(image, "png", new File(filePath));
       } catch (IOException e) {
           System.err.println("Error saving the image: " + e.getMessage());
       }
   }

   public static void main(String[] args) {
       Grid grid = new Grid(10, "Vertical", 2); //this is the default
       grid.setVisible(true);
       // Save grid to an image file
       grid.saveGridAsImageFile("climbing_route.png");
   }
}
