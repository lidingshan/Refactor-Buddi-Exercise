/*
 * Created on Aug 6, 2007 by wyatt
 */
package org.homeunix.thecave.buddi.view.menu.items;

import java.awt.event.ActionEvent;

import org.homeunix.thecave.buddi.i18n.keys.MenuKeys;
import org.homeunix.thecave.buddi.model.prefs.PrefsModel;
import org.homeunix.thecave.buddi.view.MainFrame;
import org.homeunix.thecave.buddi.view.ScheduleFrame;
import org.homeunix.thecave.moss.exception.WindowOpenException;
import org.homeunix.thecave.moss.swing.menu.MossMenuItem;

public class EditViewScheduledTransactions extends MossMenuItem{
	public static final long serialVersionUID = 0;

	//This has to be a AccountFrame, as we need to get selected accounts.
	public EditViewScheduledTransactions(MainFrame frame) {
		super(frame, PrefsModel.getInstance().getTranslator().get(MenuKeys.MENU_EDIT_VIEW_SCHEDULED_TRANSACTIONS));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ScheduleFrame scheduledTransactionsFrame = new ScheduleFrame((MainFrame) getFrame());
			scheduledTransactionsFrame.openWindow(PrefsModel.getInstance().getScheduledTransactionWindowSize(), PrefsModel.getInstance().getScheduledTransactionWindowLocation());
		}
		catch (WindowOpenException foe){
			foe.printStackTrace();
		}
	}
}