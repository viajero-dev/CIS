/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis;

import com.vg.hrm.user.service.*;
import com.vg.hrm.user.servicemgr.*;
import com.vg.scfc.financing.cis.ent.CharacterReference;
import com.vg.scfc.financing.cis.ent.MemoToFile;
import com.vg.scfc.financing.cis.entmgr.VehicleManager;
import com.vg.scfc.financing.cis.service.*;
import com.vg.scfc.financing.cis.servicemgr.*;
import com.vg.scfc.financing.commons.service.*;
import com.vg.scfc.financing.commons.servicemgr.*;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import java.rmi.registry.Registry;

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
    }

    public static void main(String[] args) {
        try {
            ServerInfoMain tx = new ServerInfoMain();
            tx.createRegistry(SettingProperties.getInstance().getServer(), SettingProperties.getInstance().getPort());
            tx.initRemoteObjects();
            tx.bindRemoteObjects();
            ConnectionProperties.setupConnection();
            VehicleManager.getInstance().initSessionFactory();
            new ServerInfoMainFrame().setVisible(true);
        } catch (Exception e) {
            System.exit(0);
        }

    }
}
