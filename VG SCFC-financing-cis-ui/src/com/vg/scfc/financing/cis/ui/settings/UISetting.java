/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.settings;

import com.vg.hrm.user.ent.Employee;
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
import com.vg.scfc.financing.commons.ent.Location;

/**
 *
 * @author rodel
 */
public class UISetting {

    private static Location storeLocation;
    private static Employee systemUser;
    private static String computerName;

    /* RMI - Services */
    private static AddressService addressService;
    private static ApplianceService applianceService;
    private static CharacterReferenceService characterReferenceService;
    private static CompanyService companyService;
    private static CreditRefService creditRefService;
    private static CustomerCashInfoService customerCashInfoService;
    private static CustomerService customerService;
    private static DependentService dependentService;
    private static EmploymentService employmentService;
    private static ExpenditureService expenditureService;
    private static ExpenditureTypeService expenditureTypeService;
    private static FamilyService familyService;
    private static LandService landService;
    private static LandTypeService landTypeService;
    private static MachineryService machineryService;
    private static MemoToFileService memoToFileService;
    private static PersonTypeService personTypeService;
    private static PurchaseOrderService purchaseOrderService;
    private static ReligionService religionService;
    private static RepresentativeEmploymentService representativeEmploymentService;
    private static SiblingService siblingService;
    private static SourceOfIncomeService sourceOfIncomeService;
    private static TransactionFormService transactionFormService;
    private static TransactionModeService transactionModeService;
    private static TribeService tribeService;
    private static VehicleService vehicleService;
    private static PersonalInfoService personalInfoService;
    private static AssetService assetService;

    public static AssetService getAssetService() {
        return assetService;
    }

    public static void setAssetService(AssetService assetService) {
        UISetting.assetService = assetService;
    }

    public static PersonalInfoService getPersonalInfoService() {
        return personalInfoService;
    }

    public static void setPersonalInfoService(PersonalInfoService personalInfoService) {
        UISetting.personalInfoService = personalInfoService;
    }

    public static Location getStoreLocation() {
        return storeLocation;
    }

    public static void setStoreLocation(Location storeLocation) {
        UISetting.storeLocation = storeLocation;
    }

    public static Employee getSystemUser() {
        return systemUser;
    }

    public static void setSystemUser(Employee systemUser) {
        UISetting.systemUser = systemUser;
    }

    public static String getComputerName() {
        return computerName;
    }

    public static void setComputerName(String computerName) {
        UISetting.computerName = computerName;
    }

    public static AddressService getAddressService() {
        return addressService;
    }

    public static void setAddressService(AddressService addressService) {
        UISetting.addressService = addressService;
    }

    public static ApplianceService getApplianceService() {
        return applianceService;
    }

    public static void setApplianceService(ApplianceService applianceService) {
        UISetting.applianceService = applianceService;
    }

    public static CharacterReferenceService getCharacterReferenceService() {
        return characterReferenceService;
    }

    public static void setCharacterReferenceService(CharacterReferenceService characterReferenceService) {
        UISetting.characterReferenceService = characterReferenceService;
    }

    public static CompanyService getCompanyService() {
        return companyService;
    }

    public static void setCompanyService(CompanyService companyService) {
        UISetting.companyService = companyService;
    }

    public static CreditRefService getCreditRefService() {
        return creditRefService;
    }

    public static void setCreditRefService(CreditRefService creditRefService) {
        UISetting.creditRefService = creditRefService;
    }

    public static CustomerCashInfoService getCustomerCashInfoService() {
        return customerCashInfoService;
    }

    public static void setCustomerCashInfoService(CustomerCashInfoService customerCashInfoService) {
        UISetting.customerCashInfoService = customerCashInfoService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static void setCustomerService(CustomerService customerService) {
        UISetting.customerService = customerService;
    }

    public static DependentService getDependentService() {
        return dependentService;
    }

    public static void setDependentService(DependentService dependentService) {
        UISetting.dependentService = dependentService;
    }

    public static EmploymentService getEmploymentService() {
        return employmentService;
    }

    public static void setEmploymentService(EmploymentService employmentService) {
        UISetting.employmentService = employmentService;
    }

    public static ExpenditureService getExpenditureService() {
        return expenditureService;
    }

    public static void setExpenditureService(ExpenditureService expenditureService) {
        UISetting.expenditureService = expenditureService;
    }

    public static ExpenditureTypeService getExpenditureTypeService() {
        return expenditureTypeService;
    }

    public static void setExpenditureTypeService(ExpenditureTypeService expenditureTypeService) {
        UISetting.expenditureTypeService = expenditureTypeService;
    }

    public static FamilyService getFamilyService() {
        return familyService;
    }

    public static void setFamilyService(FamilyService familyService) {
        UISetting.familyService = familyService;
    }

    public static LandService getLandService() {
        return landService;
    }

    public static void setLandService(LandService landService) {
        UISetting.landService = landService;
    }

    public static LandTypeService getLandTypeService() {
        return landTypeService;
    }

    public static void setLandTypeService(LandTypeService landTypeService) {
        UISetting.landTypeService = landTypeService;
    }

    public static MachineryService getMachineryService() {
        return machineryService;
    }

    public static void setMachineryService(MachineryService machineryService) {
        UISetting.machineryService = machineryService;
    }

    public static MemoToFileService getMemoToFileService() {
        return memoToFileService;
    }

    public static void setMemoToFileService(MemoToFileService memoToFileService) {
        UISetting.memoToFileService = memoToFileService;
    }

    public static PersonTypeService getPersonTypeService() {
        return personTypeService;
    }

    public static void setPersonTypeService(PersonTypeService personTypeService) {
        UISetting.personTypeService = personTypeService;
    }

    public static PurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    public static void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
        UISetting.purchaseOrderService = purchaseOrderService;
    }

    public static ReligionService getReligionService() {
        return religionService;
    }

    public static void setReligionService(ReligionService religionService) {
        UISetting.religionService = religionService;
    }

    public static RepresentativeEmploymentService getRepresentativeEmploymentService() {
        return representativeEmploymentService;
    }

    public static void setRepresentativeEmploymentService(RepresentativeEmploymentService representativeEmploymentService) {
        UISetting.representativeEmploymentService = representativeEmploymentService;
    }

    public static SiblingService getSiblingService() {
        return siblingService;
    }

    public static void setSiblingService(SiblingService siblingService) {
        UISetting.siblingService = siblingService;
    }

    public static SourceOfIncomeService getSourceOfIncomeService() {
        return sourceOfIncomeService;
    }

    public static void setSourceOfIncomeService(SourceOfIncomeService sourceOfIncomeService) {
        UISetting.sourceOfIncomeService = sourceOfIncomeService;
    }

    public static TransactionFormService getTransactionFormService() {
        return transactionFormService;
    }

    public static void setTransactionFormService(TransactionFormService transactionFormService) {
        UISetting.transactionFormService = transactionFormService;
    }

    public static TransactionModeService getTransactionModeService() {
        return transactionModeService;
    }

    public static void setTransactionModeService(TransactionModeService transactionModeService) {
        UISetting.transactionModeService = transactionModeService;
    }

    public static TribeService getTribeService() {
        return tribeService;
    }

    public static void setTribeService(TribeService tribeService) {
        UISetting.tribeService = tribeService;
    }

    public static VehicleService getVehicleService() {
        return vehicleService;
    }

    public static void setVehicleService(VehicleService vehicleService) {
        UISetting.vehicleService = vehicleService;
    }

}
