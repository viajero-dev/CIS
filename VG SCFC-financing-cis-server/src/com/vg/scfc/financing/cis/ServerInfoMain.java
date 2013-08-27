/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis;

import com.vg.hrm.user.service.EmployeeService;
import com.vg.hrm.user.service.UserService;
import com.vg.hrm.user.servicemgr.EmployeeServiceManager;
import com.vg.hrm.user.servicemgr.UserServiceManager;
import com.vg.hrm.user.util.HrmUserUtil;
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
import com.vg.scfc.financing.cis.service.LiveUpdatePictureService;
import com.vg.scfc.financing.cis.service.MachineryService;
import com.vg.scfc.financing.cis.service.MemoToFileService;
import com.vg.scfc.financing.cis.service.PersonTypeService;
import com.vg.scfc.financing.cis.service.PersonalInfoService;
import com.vg.scfc.financing.cis.service.PrintReportService;
import com.vg.scfc.financing.cis.service.PurchaseOrderService;
import com.vg.scfc.financing.cis.service.ReligionService;
import com.vg.scfc.financing.cis.service.RepresentativeEmploymentService;
import com.vg.scfc.financing.cis.service.SiblingService;
import com.vg.scfc.financing.cis.service.SourceOfIncomeService;
import com.vg.scfc.financing.cis.service.TransactionFormService;
import com.vg.scfc.financing.cis.service.TransactionModeService;
import com.vg.scfc.financing.cis.service.TribeService;
import com.vg.scfc.financing.cis.service.VehicleService;
import com.vg.scfc.financing.cis.servicemgr.AddressServiceManager;
import com.vg.scfc.financing.cis.servicemgr.ApplianceServiceManager;
import com.vg.scfc.financing.cis.servicemgr.AssetServiceManager;
import com.vg.scfc.financing.cis.servicemgr.CharacterReferenceServiceManager;
import com.vg.scfc.financing.cis.servicemgr.CompanyServiceManager;
import com.vg.scfc.financing.cis.servicemgr.CreditRefServiceManager;
import com.vg.scfc.financing.cis.servicemgr.CustomerCashInfoServiceManager;
import com.vg.scfc.financing.cis.servicemgr.CustomerServiceManager;
import com.vg.scfc.financing.cis.servicemgr.DependentServiceManager;
import com.vg.scfc.financing.cis.servicemgr.EmploymentServiceManager;
import com.vg.scfc.financing.cis.servicemgr.ExpenditureServiceManager;
import com.vg.scfc.financing.cis.servicemgr.ExpenditureTypeServiceManager;
import com.vg.scfc.financing.cis.servicemgr.FamilyServiceManager;
import com.vg.scfc.financing.cis.servicemgr.IdentificationServiceManager;
import com.vg.scfc.financing.cis.servicemgr.LandServiceManager;
import com.vg.scfc.financing.cis.servicemgr.LandTypeServiceManager;
import com.vg.scfc.financing.cis.servicemgr.LiveUpdatePictureServiceManager;
import com.vg.scfc.financing.cis.servicemgr.MachineryServiceManager;
import com.vg.scfc.financing.cis.servicemgr.MemoToFileServiceManager;
import com.vg.scfc.financing.cis.servicemgr.PersonTypeServiceManager;
import com.vg.scfc.financing.cis.servicemgr.PersonalInfoServiceManager;
import com.vg.scfc.financing.cis.servicemgr.PrintReportServiceManager;
import com.vg.scfc.financing.cis.servicemgr.PurchaseOrderServiceManager;
import com.vg.scfc.financing.cis.servicemgr.ReligionServiceManager;
import com.vg.scfc.financing.cis.servicemgr.RepresentativeEmploymentServiceManager;
import com.vg.scfc.financing.cis.servicemgr.SiblingServiceManager;
import com.vg.scfc.financing.cis.servicemgr.SourceOfIncomeServiceManager;
import com.vg.scfc.financing.cis.servicemgr.TransactionFormServiceManager;
import com.vg.scfc.financing.cis.servicemgr.TransactionModeServiceManager;
import com.vg.scfc.financing.cis.servicemgr.TribeServiceManager;
import com.vg.scfc.financing.cis.servicemgr.VehicleServiceManager;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.entmgr.MiscManager;
import com.vg.scfc.financing.commons.service.BarangayService;
import com.vg.scfc.financing.commons.service.ControlAllowedAccessService;
import com.vg.scfc.financing.commons.service.LocationService;
import com.vg.scfc.financing.commons.service.ReportHeaderService;
import com.vg.scfc.financing.commons.servicemgr.BarangayServiceManager;
import com.vg.scfc.financing.commons.servicemgr.ControlAllowedAccessServiceManager;
import com.vg.scfc.financing.commons.servicemgr.LocationServiceManager;
import com.vg.scfc.financing.commons.servicemgr.ReportHeaderServiceManager;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import com.vg.vmi.dealer.uts.service.McColorService;
import com.vg.vmi.dealer.uts.service.McMakeService;
import com.vg.vmi.dealer.uts.service.McModelService;
import com.vg.vmi.dealer.uts.servicemgr.McColorServiceManager;
import com.vg.vmi.dealer.uts.servicemgr.McMakeServiceManager;
import com.vg.vmi.dealer.uts.servicemgr.McModelServiceManager;
import com.vg.vmi.dealer.uts.util.UnitTrackingUtil;
import java.awt.Font;
import static java.rmi.registry.LocateRegistry.getRegistry;
import java.rmi.registry.Registry;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import vg.img.service.ImageHandlingService;
import vg.img.servicemgr.ImageHandlingManager;
import vg.img.util.ImageSetting;

/**
 *
 * @author jp
 */
public class ServerInfoMain {

    private ControlAllowedAccessServiceManager controlAllowedAccessServiceManager;
    private LocationServiceManager locationServiceManager;
    private UserServiceManager userServiceManager;
    private EmployeeServiceManager employeeServiceManager;
    private AddressServiceManager addressServiceManager;
    private ApplianceServiceManager applianceServiceManager;
    private CharacterReferenceServiceManager characterReferenceServiceManager;
    private CompanyServiceManager companyServiceManager;
    private CreditRefServiceManager creditRefServiceManager;
    private CustomerCashInfoServiceManager customerCashInfoServiceManager;
    private CustomerServiceManager customerServiceManager;
    private DependentServiceManager dependentServiceManager;
    private EmploymentServiceManager employmentServiceManager;
    private ExpenditureServiceManager expenditureServiceManager;
    private ExpenditureTypeServiceManager expenditureTypeServiceManager;
    private FamilyServiceManager familyServiceManager;
    private LandServiceManager landServiceManager;
    private LandTypeServiceManager landTypeServiceManager;
    private MachineryServiceManager machineryServiceManager;
    private MemoToFileServiceManager memoToFileServiceManager;
    private PersonTypeServiceManager personTypeServiceManager;
    private PurchaseOrderServiceManager purchaseOrderServiceManager;
    private ReligionServiceManager religionServiceManager;
    private RepresentativeEmploymentServiceManager representativeEmploymentServiceManager;
    private SiblingServiceManager siblingServiceManager;
    private SourceOfIncomeServiceManager sourceOfIncomeServiceManager;
    private TransactionFormServiceManager transactionFormServiceManager;
    private TransactionModeServiceManager transactionModeServiceManager;
    private TribeServiceManager tribeServiceManager;
    private VehicleServiceManager vehicleServiceManager;
    private PersonalInfoServiceManager personalInfoServiceManager;
    private AssetServiceManager assetServiceManager;
    private Registry registry;
    private IdentificationServiceManager identificationServiceManager;
    private BarangayServiceManager barangayServiceManager;
    private McMakeServiceManager makeServiceManager;
    private McColorServiceManager colorServiceManager;
    private McModelServiceManager modelServiceManager;
    private PrintReportServiceManager printReportServiceManager;
    private ImageHandlingManager imageHandlingServiceManager;
    private LiveUpdatePictureServiceManager liveUpdatePictureServiceManager;
    private ReportHeaderServiceManager reportHeaderServiceManager;

    private void createRegistry(String host, int port) throws Exception {
        System.setProperty("java.rmi.server.hostname", host);
        registry = java.rmi.registry.LocateRegistry.createRegistry(port);
    }

    private void initRemoteObjects() throws Exception {
        controlAllowedAccessServiceManager = new ControlAllowedAccessServiceManager();
        locationServiceManager = new LocationServiceManager();
        userServiceManager = new UserServiceManager();
        employeeServiceManager = new EmployeeServiceManager();
        addressServiceManager = new AddressServiceManager();
        applianceServiceManager = new ApplianceServiceManager();
        characterReferenceServiceManager = new CharacterReferenceServiceManager();
        companyServiceManager = new CompanyServiceManager();
        creditRefServiceManager = new CreditRefServiceManager();
        customerCashInfoServiceManager = new CustomerCashInfoServiceManager();
        customerServiceManager = new CustomerServiceManager();
        dependentServiceManager = new DependentServiceManager();
        employmentServiceManager = new EmploymentServiceManager();
        expenditureServiceManager = new ExpenditureServiceManager();
        expenditureTypeServiceManager = new ExpenditureTypeServiceManager();
        familyServiceManager = new FamilyServiceManager();
        landServiceManager = new LandServiceManager();
        landTypeServiceManager = new LandTypeServiceManager();
        machineryServiceManager = new MachineryServiceManager();
        memoToFileServiceManager = new MemoToFileServiceManager();
        personTypeServiceManager = new PersonTypeServiceManager();
        purchaseOrderServiceManager = new PurchaseOrderServiceManager();
        religionServiceManager = new ReligionServiceManager();
        representativeEmploymentServiceManager = new RepresentativeEmploymentServiceManager();
        siblingServiceManager = new SiblingServiceManager();
        sourceOfIncomeServiceManager = new SourceOfIncomeServiceManager();
        transactionFormServiceManager = new TransactionFormServiceManager();
        transactionModeServiceManager = new TransactionModeServiceManager();
        tribeServiceManager = new TribeServiceManager();
        vehicleServiceManager = new VehicleServiceManager();
        personalInfoServiceManager = new PersonalInfoServiceManager();
        assetServiceManager = new AssetServiceManager();
        identificationServiceManager = new IdentificationServiceManager();
        barangayServiceManager = new BarangayServiceManager();
        makeServiceManager = new McMakeServiceManager();
        colorServiceManager = new McColorServiceManager();
        modelServiceManager = new McModelServiceManager();
        printReportServiceManager = new PrintReportServiceManager();
        imageHandlingServiceManager = new ImageHandlingManager();
        liveUpdatePictureServiceManager = new LiveUpdatePictureServiceManager();
        reportHeaderServiceManager = new ReportHeaderServiceManager();
    }

    private void bindRemoteObjects() throws Exception {
        registry.bind(ControlAllowedAccessService.class.getSimpleName(), controlAllowedAccessServiceManager);
        registry.bind(LocationService.class.getSimpleName(), locationServiceManager);
        registry.bind(UserService.class.getSimpleName(), userServiceManager);
        registry.bind(EmployeeService.class.getSimpleName(), employeeServiceManager);
        registry.bind(AddressService.class.getSimpleName(), addressServiceManager);
        registry.bind(ApplianceService.class.getSimpleName(), applianceServiceManager);
        registry.bind(CharacterReferenceService.class.getSimpleName(), characterReferenceServiceManager);
        registry.bind(CompanyService.class.getSimpleName(), companyServiceManager);
        registry.bind(CreditRefService.class.getSimpleName(), creditRefServiceManager);
        registry.bind(CustomerCashInfoService.class.getSimpleName(), customerCashInfoServiceManager);
        registry.bind(CustomerService.class.getSimpleName(), customerServiceManager);
        registry.bind(DependentService.class.getSimpleName(), dependentServiceManager);
        registry.bind(EmploymentService.class.getSimpleName(), employmentServiceManager);
        registry.bind(ExpenditureService.class.getSimpleName(), expenditureServiceManager);
        registry.bind(ExpenditureTypeService.class.getSimpleName(), expenditureTypeServiceManager);
        registry.bind(FamilyService.class.getSimpleName(), familyServiceManager);
        registry.bind(LandService.class.getSimpleName(), landServiceManager);
        registry.bind(LandTypeService.class.getSimpleName(), landTypeServiceManager);
        registry.bind(MachineryService.class.getSimpleName(), machineryServiceManager);
        registry.bind(MemoToFileService.class.getSimpleName(), memoToFileServiceManager);
        registry.bind(PersonTypeService.class.getSimpleName(), personTypeServiceManager);
        registry.bind(PurchaseOrderService.class.getSimpleName(), purchaseOrderServiceManager);
        registry.bind(ReligionService.class.getSimpleName(), religionServiceManager);
        registry.bind(RepresentativeEmploymentService.class.getSimpleName(), representativeEmploymentServiceManager);
        registry.bind(SiblingService.class.getSimpleName(), siblingServiceManager);
        registry.bind(SourceOfIncomeService.class.getSimpleName(), sourceOfIncomeServiceManager);
        registry.bind(TransactionFormService.class.getSimpleName(), transactionFormServiceManager);
        registry.bind(TransactionModeService.class.getSimpleName(), transactionModeServiceManager);
        registry.bind(TribeService.class.getSimpleName(), tribeServiceManager);
        registry.bind(VehicleService.class.getSimpleName(), vehicleServiceManager);
        registry.bind(PersonalInfoService.class.getSimpleName(), personalInfoServiceManager);
        registry.bind(AssetService.class.getSimpleName(), assetServiceManager);
        registry.bind(IdentificationService.class.getSimpleName(), identificationServiceManager);
        registry.bind(BarangayService.class.getSimpleName(), barangayServiceManager);
        registry.bind(McMakeService.class.getSimpleName(), makeServiceManager);
        registry.bind(McColorService.class.getSimpleName(), colorServiceManager);
        registry.bind(McModelService.class.getSimpleName(), modelServiceManager);
        registry.bind(PrintReportService.class.getSimpleName(), printReportServiceManager);
        registry.bind(ImageHandlingService.class.getSimpleName(), imageHandlingServiceManager);
        registry.bind(LiveUpdatePictureService.class.getSimpleName(), liveUpdatePictureServiceManager);
        registry.bind(ReportHeaderService.class.getSimpleName(), reportHeaderServiceManager);
    }

    public static void main(String[] args) {
        try {
            System.setProperty("Quaqua.tabLayoutPolicy", "wrap");

            UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
            ServerInfoMain tx = new ServerInfoMain();
            tx.createRegistry(SettingProperties.getInstance().getServer(), SettingProperties.getInstance().getPort());
            tx.initRemoteObjects();
            tx.bindRemoteObjects();
            ConnectionProperties.setupConnection();
            HrmUserUtil.setSessionFactory(ClientInfoUtil.getSessionFactory());
            CommonsUtil.setSessionFactory(ClientInfoUtil.getSessionFactory());
            UnitTrackingUtil.setSessionFactory(ClientInfoUtil.getSessionFactory());
            ImageSetting.setPath(MiscManager.getInstance().findByCode("PIC_PATH").getDescription());  
            new ServerInfoMainFrame().setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void setFontSize() {
        int fontSize = 20;
        Hashtable defaults = UIManager.getDefaults();
        Enumeration keys = defaults.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();

            if ((key instanceof String) && (((String) key).endsWith(".font"))) {
                FontUIResource font = (FontUIResource) UIManager.get(key);
                System.out.println("---" + key);
                UIManager.put(key, new FontUIResource("Lucida Grande", Font.BOLD, 20));
                defaults.put(key, new FontUIResource("Lucida Grande", Font.BOLD, 20));
            }
        }
    }

    public static void setUIFont() {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            
//            if ((key instanceof String) && (((String) key).endsWith(".font"))) {
            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
                System.out.println(key);
                UIManager.put(key, new FontUIResource("Lucida Grande", Font.PLAIN, 20));
            }
        }
    }
}
