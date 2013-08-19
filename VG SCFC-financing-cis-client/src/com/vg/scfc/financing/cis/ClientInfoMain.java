/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis;

import com.vg.commons.util.StringUtils;
import com.vg.commons.util.UIMgr;
import com.vg.hrm.user.service.EmployeeService;
import com.vg.hrm.user.service.UserService;
import com.vg.scfc.financing.cis.service.AddressService;
import com.vg.scfc.financing.cis.service.ApplianceService;
import com.vg.scfc.financing.cis.service.AssetService;
import com.vg.scfc.financing.cis.service.CharacterReferenceService;
import com.vg.scfc.financing.cis.service.CompanyService;
import com.vg.scfc.financing.cis.service.CreditRefService;
import com.vg.scfc.financing.cis.service.CustomerCashInfoService;
import com.vg.scfc.financing.cis.service.CustomerService;
import com.vg.scfc.financing.cis.service.DependentService;
import com.vg.scfc.financing.cis.service.EmploymentService;
import com.vg.scfc.financing.cis.service.ExpenditureService;
import com.vg.scfc.financing.cis.service.ExpenditureTypeService;
import com.vg.scfc.financing.cis.service.FamilyService;
import com.vg.scfc.financing.cis.service.IdentificationService;
import com.vg.scfc.financing.cis.service.LandService;
import com.vg.scfc.financing.cis.service.LandTypeService;
import com.vg.scfc.financing.cis.service.MachineryService;
import com.vg.scfc.financing.cis.service.MemoToFileService;
import com.vg.scfc.financing.cis.service.PersonTypeService;
import com.vg.scfc.financing.cis.service.PersonalInfoService;
import com.vg.scfc.financing.cis.service.PurchaseOrderService;
import com.vg.scfc.financing.cis.service.ReligionService;
import com.vg.scfc.financing.cis.service.RepresentativeEmploymentService;
import com.vg.scfc.financing.cis.service.SiblingService;
import com.vg.scfc.financing.cis.service.SourceOfIncomeService;
import com.vg.scfc.financing.cis.service.TransactionFormService;
import com.vg.scfc.financing.cis.service.TransactionModeService;
import com.vg.scfc.financing.cis.service.TribeService;
import com.vg.scfc.financing.cis.service.VehicleService;
import com.vg.scfc.financing.cis.ui.frames.ClientInformationSystemFrame;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.commons.service.BarangayService;
import com.vg.scfc.financing.commons.service.ControlAllowedAccessService;
import com.vg.scfc.financing.commons.service.LocationService;
import com.vg.scfc.financing.commons.service.LoginListener;
import com.vg.scfc.financing.commons.ui.dlg.LoginDlg;
import com.vg.vmi.dealer.uts.service.McColorService;
import com.vg.vmi.dealer.uts.service.McMakeService;
import com.vg.vmi.dealer.uts.service.McModelService;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jp
 */
public class ClientInfoMain implements LoginListener {

    private ControlAllowedAccessService controlAllowedAccessService;
    private LocationService locationService;
    private UserService userService;
    private EmployeeService employeeService;
    private AddressService addressService;
    private ApplianceService applianceService;
    private CharacterReferenceService characterReferenceService;
    private CompanyService companyService;
    private CreditRefService creditRefService;
    private CustomerCashInfoService customerCashInfoService;
    private CustomerService customerService;
    private DependentService dependentService;
    private EmploymentService employmentService;
    private ExpenditureService expenditureService;
    private ExpenditureTypeService expenditureTypeService;
    private FamilyService familyService;
    private LandService landService;
    private LandTypeService landTypeService;
    private MachineryService machineryService;
    private MemoToFileService memoToFileService;
    private PersonTypeService personTypeService;
    private PurchaseOrderService purchaseOrderService;
    private ReligionService religionService;
    private RepresentativeEmploymentService representativeEmploymentService;
    private SiblingService siblingService;
    private SourceOfIncomeService sourceOfIncomeService;
    private TransactionFormService transactionFormService;
    private TransactionModeService transactionModeService;
    private TribeService tribeService;
    private VehicleService vehicleService;
    private PersonalInfoService personalInfoService;
    private AssetService assetService;
    private IdentificationService identificationService;
    private BarangayService barangayService;
    private McMakeService makeService;
    private McColorService colorService;
    private McModelService modelService;
    private Registry registry;
    private LoginDlg loginDlg;
    private int failedLoginCounter = 0;
    private final int MAX_FAILED_LOGIN_ALLOWED = 3;

    public void getRegistry(String host, int port) throws RemoteException {
        if (registry == null) {
            registry = LocateRegistry.getRegistry(host, port);
        }
    }

    public void initService() throws Exception {
        controlAllowedAccessService = (ControlAllowedAccessService) registry.lookup(ControlAllowedAccessService.class.getSimpleName());
        locationService = (LocationService) registry.lookup(LocationService.class.getSimpleName());
        userService = (UserService) registry.lookup(UserService.class.getSimpleName());
        employeeService = (EmployeeService) registry.lookup(EmployeeService.class.getSimpleName());
        addressService = (AddressService) registry.lookup(AddressService.class.getSimpleName());
        applianceService = (ApplianceService) registry.lookup(ApplianceService.class.getSimpleName());
        assetService = (AssetService) registry.lookup(AssetService.class.getSimpleName());
        characterReferenceService = (CharacterReferenceService) registry.lookup(CharacterReferenceService.class.getSimpleName());
        companyService = (CompanyService) registry.lookup(CompanyService.class.getSimpleName());
        creditRefService = (CreditRefService) registry.lookup(CreditRefService.class.getSimpleName());
        customerCashInfoService = (CustomerCashInfoService) registry.lookup(CustomerCashInfoService.class.getSimpleName());
        customerService = (CustomerService) registry.lookup(CustomerService.class.getSimpleName());
        dependentService = (DependentService) registry.lookup(DependentService.class.getSimpleName());
        employmentService = (EmploymentService) registry.lookup(EmploymentService.class.getSimpleName());
        expenditureService = (ExpenditureService) registry.lookup(ExpenditureService.class.getSimpleName());
        expenditureTypeService = (ExpenditureTypeService) registry.lookup(ExpenditureTypeService.class.getSimpleName());
        familyService = (FamilyService) registry.lookup(FamilyService.class.getSimpleName());
        landService = (LandService) registry.lookup(LandService.class.getSimpleName());
        landTypeService = (LandTypeService) registry.lookup(LandTypeService.class.getSimpleName());
        machineryService = (MachineryService) registry.lookup(MachineryService.class.getSimpleName());
        memoToFileService = (MemoToFileService) registry.lookup(MemoToFileService.class.getSimpleName());
        personTypeService = (PersonTypeService) registry.lookup(PersonTypeService.class.getSimpleName());
        personalInfoService = (PersonalInfoService) registry.lookup(PersonalInfoService.class.getSimpleName());
        purchaseOrderService = (PurchaseOrderService) registry.lookup(PurchaseOrderService.class.getSimpleName());
        religionService = (ReligionService) registry.lookup(ReligionService.class.getSimpleName());
        representativeEmploymentService = (RepresentativeEmploymentService) registry.lookup(RepresentativeEmploymentService.class.getSimpleName());
        siblingService = (SiblingService) registry.lookup(SiblingService.class.getSimpleName());
        sourceOfIncomeService = (SourceOfIncomeService) registry.lookup(SourceOfIncomeService.class.getSimpleName());
        transactionFormService = (TransactionFormService) registry.lookup(TransactionFormService.class.getSimpleName());
        transactionModeService = (TransactionModeService) registry.lookup(TransactionModeService.class.getSimpleName());
        vehicleService = (VehicleService) registry.lookup(VehicleService.class.getSimpleName());
        tribeService = (TribeService) registry.lookup(TribeService.class.getSimpleName());
        identificationService = (IdentificationService) registry.lookup(IdentificationService.class.getSimpleName());
        barangayService = (BarangayService) registry.lookup(BarangayService.class.getSimpleName());
        makeService = (McMakeService) registry.lookup(McMakeService.class.getSimpleName());
        colorService = (McColorService) registry.lookup(McColorService.class.getSimpleName());
        modelService = (McModelService) registry.lookup(McModelService.class.getSimpleName());
    }

    public void setUISettings() {
        UISetting.setAddressService(addressService);
        UISetting.setApplianceService(applianceService);
        UISetting.setAssetService(assetService);
        UISetting.setCharacterReferenceService(characterReferenceService);
        UISetting.setCompanyService(companyService);
        UISetting.setCreditRefService(creditRefService);
        UISetting.setCustomerCashInfoService(customerCashInfoService);
        UISetting.setCustomerService(customerService);
        UISetting.setDependentService(dependentService);
        UISetting.setEmploymentService(employmentService);
        UISetting.setExpenditureService(expenditureService);
        UISetting.setExpenditureTypeService(expenditureTypeService);
        UISetting.setFamilyService(familyService);
        UISetting.setLandService(landService);
        UISetting.setLandTypeService(landTypeService);
        UISetting.setMachineryService(machineryService);
        UISetting.setMemoToFileService(memoToFileService);
        UISetting.setPersonTypeService(personTypeService);
        UISetting.setPersonalInfoService(personalInfoService);
        UISetting.setPurchaseOrderService(purchaseOrderService);
        UISetting.setReligionService(religionService);
        UISetting.setRepresentativeEmploymentService(representativeEmploymentService);
        UISetting.setSiblingService(siblingService);
        UISetting.setSourceOfIncomeService(sourceOfIncomeService);
        UISetting.setTransactionFormService(transactionFormService);
        UISetting.setTransactionModeService(transactionModeService);
        UISetting.setTribeService(tribeService);
        UISetting.setVehicleService(vehicleService);
        UISetting.setIdentificationService(identificationService);
        UISetting.setBarangayService(barangayService);
        UISetting.setMakeService(makeService);
        UISetting.setColorService(colorService);
        UISetting.setModelService(modelService);
        UISetting.setEmployeeService(employeeService);
    }

    public void showLogInDialog(String locID, boolean enable) {

        loginDlg = new LoginDlg(null, true);
        loginDlg.setLoginListener(this);
        UIMgr.centerToScreen(loginDlg);

        loginDlg.getPnlLogin().setEmployeeService(employeeService);
        loginDlg.getPnlLogin().setLocationService(locationService);
        loginDlg.getPnlLogin().setUserService(userService);
        loginDlg.getPnlLogin().setControlAllowedAccessService(controlAllowedAccessService);

        loginDlg.setDefaults(locID, enable);
        loginDlg.getPnlLogin().setAppCode("04");
        loginDlg.setTitle("LOGIN TO CIS");
        loginDlg.toFront();
        loginDlg.setVisible(true);
    }

    @Override
    public void cancelLogin() {
        System.exit(0);
    }

    @Override
    public void login() {
        try {
            if (loginDlg.getUser().isValidPassword(loginDlg.getInputPassword())) {

                UISetting.setStoreLocation(loginDlg.getStoreLocation());
                UISetting.setSystemUser(loginDlg.getEmployee());
                UISetting.setComputerName(InetAddress.getLocalHost().getHostName());
                ClientInformationSystemFrame c = new ClientInformationSystemFrame();
                c.getLblStorelocation().setText( loginDlg.getUser().getId() + " - " + UISetting.getSystemUser().getFullName() + " @ " + loginDlg.getStoreLocation().getId() + " - " + loginDlg.getStoreLocation().getDescription());
                c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                c.setVisible(true);
                loginDlg.dispose();
                loginDlg = null;

            } else {
                failedLoginCounter++;
                if (failedLoginCounter == MAX_FAILED_LOGIN_ALLOWED) {
                    JOptionPane.showMessageDialog(null, "Invalid password."
                            + "\nFailed to login " + MAX_FAILED_LOGIN_ALLOWED + " times."
                            + "\nApplication will terminate.",
                            "ACCESS DENIED", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                if (loginDlg.getVerifyMsg().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid password."
                            + "\nYou have " + (MAX_FAILED_LOGIN_ALLOWED - failedLoginCounter)
                            + " of " + MAX_FAILED_LOGIN_ALLOWED + " attempts left.",
                            "ACCESS DENIED", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, loginDlg.getVerifyMsg() + " cannot be empty.", "ACCESS DENIED", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        ClientInfoMain tx = new ClientInfoMain();
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            System.setProperty("java.security.policy", "client.policy");
            System.setSecurityManager(new java.rmi.RMISecurityManager());

            if (args.length == 0) {
                JOptionPane.showMessageDialog(null, "Access Denied.", "RESTRICTED AREA", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }

            boolean x = false;
            if (args[2].equals("E")) {
                x = true;
            }

            String host = SettingProperties.getInstance().getServer();
            int port = SettingProperties.getInstance().getPort();
            tx.getRegistry(host, port);
            tx.initService();
            tx.setUISettings();

            tx.showLogInDialog(args[1], x);

        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(ClientInfoMain.class).error(StringUtils.formatException(e));
            JOptionPane.showMessageDialog(null, "Cannot connect to server.", "MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
}
