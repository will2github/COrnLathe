package com.billooms.datanavigator;

import java.awt.BorderLayout;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.Node;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top Component which serves as an ExplorerManager for all the data.
 *
 * @author Bill Ooms. Copyright 2015 Studio of Bill Ooms. All rights reserved.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
@ConvertAsProperties(
    dtd = "-//com.billooms.datanavigator//DataNavigator//EN",
    autostore = false
)
@TopComponent.Description(
    preferredID = "DataNavigatorTopComponent",
    iconBase = "com/billooms/datanavigator/navigator.png",
    persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "navigator", openAtStartup = true)
@ActionID(category = "Window", id = "com.billooms.datanavigator.DataNavigatorTopComponent")
@ActionReference(path = "Menu/Window", position = 300)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_DataNavigatorAction",
    preferredID = "DataNavigatorTopComponent"
)
@Messages({
  "CTL_DataNavigatorAction=DataNavigator",
  "CTL_DataNavigatorTopComponent=DataNavigator Window",
  "HINT_DataNavigatorTopComponent=This is a DataNavigator window"
})
public final class DataNavigatorTopComponent extends TopComponent implements ExplorerManager.Provider {

  /** Local copy of the ExplorerManager. */
  private final static ExplorerManager em = new ExplorerManager();

  /**
   * Construct the DataNavigator.
   */
  public DataNavigatorTopComponent() {
//    em = new ExplorerManager();
//    System.out.println("...DataNavigatorTopComponent.constructor em=" + em);
    initComponents();
    setName(Bundle.CTL_DataNavigatorTopComponent());
    setToolTipText(Bundle.HINT_DataNavigatorTopComponent());

    // TODO: Look at the documentation for ExplorerUtils for more info on adding actions to the actionMap.
    setLayout(new BorderLayout());
    add(new BeanTreeView(), BorderLayout.CENTER);
    em.setRootContext(Node.EMPTY);

    associateLookup(ExplorerUtils.createLookup(em, getActionMap()));
  }

  @Override
  public ExplorerManager getExplorerManager() {
    return em;
  }

//  // It is good idea to switch all listeners on and off when the
//  // component is shown or hidden. In the case of TopComponent use:
//  @Override
//  protected void componentActivated() {
//    ExplorerUtils.activateActions(em, true);
//  }
//
//  @Override
//  protected void componentDeactivated() {
//    ExplorerUtils.activateActions(em, false);
//  }
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
  @Override
  public void componentOpened() {
//    System.out.println("  ..DataNavigatorTopComponent.componentOpened");
  }

  @Override
  public void componentClosed() {
//    System.out.println("  ..DataNavigatorTopComponent.componentClosed");
  }

  void writeProperties(java.util.Properties p) {
    // better to version settings since initial version as advocated at
    // http://wiki.apidesign.org/wiki/PropertyFiles
    p.setProperty("version", "1.0");
    // TODO store your settings
  }

  void readProperties(java.util.Properties p) {
    String version = p.getProperty("version");
    // TODO read your settings according to their version
  }
}
