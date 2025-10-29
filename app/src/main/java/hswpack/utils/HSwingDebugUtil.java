package hswpack.utils;

import java.awt.Color;

import javax.swing.JPanel;

import hswpack.components.HPanel;

public class HSwingDebugUtil {
  private static final Color[] DEBUG_COLORS = {
      new Color(173, 216, 230, 150), // Light Blue
      new Color(135, 206, 235, 160), // Sky Blue
      new Color(176, 224, 230, 170), // Powder Blue
      new Color(144, 238, 144, 160), // Light Green
      new Color(152, 251, 152, 170), // Pale Green
      new Color(0, 255, 127, 180), // Spring Green
      new Color(64, 224, 208, 180), // Turquoise
      new Color(0, 191, 255, 190), // Deep Sky Blue
      new Color(32, 178, 170, 160), // Light Sea Green
      new Color(224, 255, 255, 200), // Light Cyan
      new Color(240, 255, 240, 200), // Honeydew (greenish white)
      new Color(175, 238, 238, 180), // Pale Turquoise
      new Color(0, 250, 154, 190) // Medium Spring Green
  };

  private static int autoDebugIndex = 0;

  private static int debugColorIndex = 0;

  public static void debugVisual(HPanel panel) {
    debugVisual(panel, panel.getDebugLabelPrefix() + " " + autoDebugIndex++);
  }

  public static void debugVisual(JPanel panel, String label) {
    Color color = DEBUG_COLORS[debugColorIndex++ % DEBUG_COLORS.length];
    debugVisual(panel, label, color);
  }

  public static void debugVisual(JPanel panel, Color color) {
    debugVisual(panel, null, color);
  }

  public static void debugVisual(JPanel panel, String label, Color color) {
    panel.setOpaque(true);
    panel.setBackground(color);

    if (label == null) {
      return;
    }
    panel.setToolTipText(label);
  }

}
