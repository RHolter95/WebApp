package com.richard.app.aws;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.*;
import com.amazonaws.services.identitymanagement.waiters.AmazonIdentityManagementWaiters;
import com.amazonaws.services.simpleemail.model.CreateCustomVerificationEmailTemplateRequest;
import com.amazonaws.services.simpleemail.model.CreateCustomVerificationEmailTemplateResult;
import com.amazonaws.services.simpleemail.model.CustomVerificationEmailTemplateAlreadyExistsException;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityResult;

@Service
public class AwsCreateIAM implements AmazonIdentityManagement {
	
	@Autowired
	AmazonSimpleEmail AmazonSimpleEmail;
	
	CreateCustomVerificationEmailTemplateRequest customVerificationEmailTemplate = new CreateCustomVerificationEmailTemplateRequest();
	
	public CreateUserResult CreateAWSUser(String username, String email, String password) throws InterruptedException{
		
		
		AmazonIdentityManagement client = AmazonIdentityManagementClientBuilder
		        		                .standard()
		        		                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		        		                .withRegion(Regions.US_EAST_1)
		        		                .build();
				
		try {//Create IAM user
			CreateUserRequest request = new CreateUserRequest().withUserName(username);
			CreateUserResult response = client.createUser(request);
			System.out.println(response);
		} catch (Exception e) {
			System.out.println("Create IAM account failed: " + e);
		}
		
		
		try {//Add IAM user to UserGroup
			AddUserToGroupRequest request = new AddUserToGroupRequest().withGroupName("UserGroup").withUserName(username);
			AddUserToGroupResult response = client.addUserToGroup(request);
		} catch (Exception e) {
			System.out.println("Add to group failed: " + e);
		}
		
		
		String tempString = GenerateIAMPass();
		
		
		try {//Create cutsom template for user signup email verification
			customVerificationEmailTemplate.setTemplateName("customEmail");
			customVerificationEmailTemplate.setTemplateContent("Use this password: " + tempString + " to login to user: " + username + " at AWS");
			AmazonSimpleEmail.createCustomVerificationEmailTemplate(customVerificationEmailTemplate);
		} catch (LimitExceededException e) {
			System.out.println("Failed to send verification email due to limits: " + e);
		} catch (CustomVerificationEmailTemplateAlreadyExistsException e) {
			System.out.println("Custom verification template already exists: " + e);
		}
		
		
		try {//Setup credentials password for IAM user
			CreateLoginProfileRequest request = new CreateLoginProfileRequest().withUserName(username).withPassword(tempString).withPasswordResetRequired(true);
			CreateLoginProfileResult response = client.createLoginProfile(request);
			tempString = "";
		} catch (Exception e) {
			System.out.println("Create credentials for user failed: " + e);
		}
				
		  
		//Thread.sleep(2500);
		
		//UpdateLoginProfileRequest request = new UpdateLoginProfileRequest().withUserName(username).withPassword(password);
		//password = "";
		
		//UpdateLoginProfileResult response = client.updateLoginProfile(request);
		
		GetLoginProfileRequest getProfileRequest = new GetLoginProfileRequest().withUserName(username);
		GetLoginProfileResult getProfileResponse = client.getLoginProfile(getProfileRequest);
		System.out.println(getProfileResponse);

		
		//VerifyEmailIdentityRequest request = new VerifyEmailIdentityRequest().withEmailAddress(email);
		
		//VerifyEmailIdentityResult response = client.verifyEmailIdentity(request);
		
		

		return null;
	}

	public String GenerateIAMPass() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
			     .withinRange('a', 'z').build();
			 String randomLetters = generator.generate(6);
		return randomLetters;
	}
	
	CreateCustomVerificationEmailTemplateResult createCustomVerificationEmailTemplate(CreateCustomVerificationEmailTemplateRequest CustomVerificationEmailTemplate) {
		
		return null;
	}


	@Override
	public void setEndpoint(String endpoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRegion(Region region) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AddClientIDToOpenIDConnectProviderResult addClientIDToOpenIDConnectProvider(
			AddClientIDToOpenIDConnectProviderRequest addClientIDToOpenIDConnectProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddRoleToInstanceProfileResult addRoleToInstanceProfile(
			AddRoleToInstanceProfileRequest addRoleToInstanceProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddUserToGroupResult addUserToGroup(AddUserToGroupRequest addUserToGroupRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttachGroupPolicyResult attachGroupPolicy(AttachGroupPolicyRequest attachGroupPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttachRolePolicyResult attachRolePolicy(AttachRolePolicyRequest attachRolePolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttachUserPolicyResult attachUserPolicy(AttachUserPolicyRequest attachUserPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChangePasswordResult changePassword(ChangePasswordRequest changePasswordRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateAccessKeyResult createAccessKey(CreateAccessKeyRequest createAccessKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateAccessKeyResult createAccessKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateAccountAliasResult createAccountAlias(CreateAccountAliasRequest createAccountAliasRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateGroupResult createGroup(CreateGroupRequest createGroupRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateInstanceProfileResult createInstanceProfile(
			CreateInstanceProfileRequest createInstanceProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateLoginProfileResult createLoginProfile(CreateLoginProfileRequest createLoginProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateOpenIDConnectProviderResult createOpenIDConnectProvider(
			CreateOpenIDConnectProviderRequest createOpenIDConnectProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreatePolicyResult createPolicy(CreatePolicyRequest createPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreatePolicyVersionResult createPolicyVersion(CreatePolicyVersionRequest createPolicyVersionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateRoleResult createRole(CreateRoleRequest createRoleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateSAMLProviderResult createSAMLProvider(CreateSAMLProviderRequest createSAMLProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateServiceLinkedRoleResult createServiceLinkedRole(
			CreateServiceLinkedRoleRequest createServiceLinkedRoleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateServiceSpecificCredentialResult createServiceSpecificCredential(
			CreateServiceSpecificCredentialRequest createServiceSpecificCredentialRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateUserResult createUser(CreateUserRequest createUserRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateVirtualMFADeviceResult createVirtualMFADevice(
			CreateVirtualMFADeviceRequest createVirtualMFADeviceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeactivateMFADeviceResult deactivateMFADevice(DeactivateMFADeviceRequest deactivateMFADeviceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteAccessKeyResult deleteAccessKey(DeleteAccessKeyRequest deleteAccessKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteAccountAliasResult deleteAccountAlias(DeleteAccountAliasRequest deleteAccountAliasRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicy(
			DeleteAccountPasswordPolicyRequest deleteAccountPasswordPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteGroupResult deleteGroup(DeleteGroupRequest deleteGroupRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteGroupPolicyResult deleteGroupPolicy(DeleteGroupPolicyRequest deleteGroupPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteInstanceProfileResult deleteInstanceProfile(
			DeleteInstanceProfileRequest deleteInstanceProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteLoginProfileResult deleteLoginProfile(DeleteLoginProfileRequest deleteLoginProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteOpenIDConnectProviderResult deleteOpenIDConnectProvider(
			DeleteOpenIDConnectProviderRequest deleteOpenIDConnectProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeletePolicyResult deletePolicy(DeletePolicyRequest deletePolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeletePolicyVersionResult deletePolicyVersion(DeletePolicyVersionRequest deletePolicyVersionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteRoleResult deleteRole(DeleteRoleRequest deleteRoleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteRolePermissionsBoundaryResult deleteRolePermissionsBoundary(
			DeleteRolePermissionsBoundaryRequest deleteRolePermissionsBoundaryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteRolePolicyResult deleteRolePolicy(DeleteRolePolicyRequest deleteRolePolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteSAMLProviderResult deleteSAMLProvider(DeleteSAMLProviderRequest deleteSAMLProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteSSHPublicKeyResult deleteSSHPublicKey(DeleteSSHPublicKeyRequest deleteSSHPublicKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteServerCertificateResult deleteServerCertificate(
			DeleteServerCertificateRequest deleteServerCertificateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteServiceLinkedRoleResult deleteServiceLinkedRole(
			DeleteServiceLinkedRoleRequest deleteServiceLinkedRoleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteServiceSpecificCredentialResult deleteServiceSpecificCredential(
			DeleteServiceSpecificCredentialRequest deleteServiceSpecificCredentialRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteSigningCertificateResult deleteSigningCertificate(
			DeleteSigningCertificateRequest deleteSigningCertificateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteUserResult deleteUser(DeleteUserRequest deleteUserRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteUserPermissionsBoundaryResult deleteUserPermissionsBoundary(
			DeleteUserPermissionsBoundaryRequest deleteUserPermissionsBoundaryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteUserPolicyResult deleteUserPolicy(DeleteUserPolicyRequest deleteUserPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteVirtualMFADeviceResult deleteVirtualMFADevice(
			DeleteVirtualMFADeviceRequest deleteVirtualMFADeviceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetachGroupPolicyResult detachGroupPolicy(DetachGroupPolicyRequest detachGroupPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetachRolePolicyResult detachRolePolicy(DetachRolePolicyRequest detachRolePolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetachUserPolicyResult detachUserPolicy(DetachUserPolicyRequest detachUserPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnableMFADeviceResult enableMFADevice(EnableMFADeviceRequest enableMFADeviceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenerateCredentialReportResult generateCredentialReport(
			GenerateCredentialReportRequest generateCredentialReportRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenerateCredentialReportResult generateCredentialReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccessKeyLastUsedResult getAccessKeyLastUsed(GetAccessKeyLastUsedRequest getAccessKeyLastUsedRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccountAuthorizationDetailsResult getAccountAuthorizationDetails(
			GetAccountAuthorizationDetailsRequest getAccountAuthorizationDetailsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccountAuthorizationDetailsResult getAccountAuthorizationDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccountPasswordPolicyResult getAccountPasswordPolicy(
			GetAccountPasswordPolicyRequest getAccountPasswordPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccountPasswordPolicyResult getAccountPasswordPolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccountSummaryResult getAccountSummary(GetAccountSummaryRequest getAccountSummaryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccountSummaryResult getAccountSummary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetContextKeysForCustomPolicyResult getContextKeysForCustomPolicy(
			GetContextKeysForCustomPolicyRequest getContextKeysForCustomPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetContextKeysForPrincipalPolicyResult getContextKeysForPrincipalPolicy(
			GetContextKeysForPrincipalPolicyRequest getContextKeysForPrincipalPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetCredentialReportResult getCredentialReport(GetCredentialReportRequest getCredentialReportRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetCredentialReportResult getCredentialReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetGroupResult getGroup(GetGroupRequest getGroupRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetGroupPolicyResult getGroupPolicy(GetGroupPolicyRequest getGroupPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetInstanceProfileResult getInstanceProfile(GetInstanceProfileRequest getInstanceProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetLoginProfileResult getLoginProfile(GetLoginProfileRequest getLoginProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetOpenIDConnectProviderResult getOpenIDConnectProvider(
			GetOpenIDConnectProviderRequest getOpenIDConnectProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetPolicyResult getPolicy(GetPolicyRequest getPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetPolicyVersionResult getPolicyVersion(GetPolicyVersionRequest getPolicyVersionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRoleResult getRole(GetRoleRequest getRoleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRolePolicyResult getRolePolicy(GetRolePolicyRequest getRolePolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSAMLProviderResult getSAMLProvider(GetSAMLProviderRequest getSAMLProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSSHPublicKeyResult getSSHPublicKey(GetSSHPublicKeyRequest getSSHPublicKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetServerCertificateResult getServerCertificate(GetServerCertificateRequest getServerCertificateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetServiceLinkedRoleDeletionStatusResult getServiceLinkedRoleDeletionStatus(
			GetServiceLinkedRoleDeletionStatusRequest getServiceLinkedRoleDeletionStatusRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetUserResult getUser(GetUserRequest getUserRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetUserResult getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetUserPolicyResult getUserPolicy(GetUserPolicyRequest getUserPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAccessKeysResult listAccessKeys(ListAccessKeysRequest listAccessKeysRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAccessKeysResult listAccessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAccountAliasesResult listAccountAliases(ListAccountAliasesRequest listAccountAliasesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAccountAliasesResult listAccountAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAttachedGroupPoliciesResult listAttachedGroupPolicies(
			ListAttachedGroupPoliciesRequest listAttachedGroupPoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAttachedRolePoliciesResult listAttachedRolePolicies(
			ListAttachedRolePoliciesRequest listAttachedRolePoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAttachedUserPoliciesResult listAttachedUserPolicies(
			ListAttachedUserPoliciesRequest listAttachedUserPoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListEntitiesForPolicyResult listEntitiesForPolicy(
			ListEntitiesForPolicyRequest listEntitiesForPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListGroupPoliciesResult listGroupPolicies(ListGroupPoliciesRequest listGroupPoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListGroupsResult listGroups(ListGroupsRequest listGroupsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListGroupsResult listGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListGroupsForUserResult listGroupsForUser(ListGroupsForUserRequest listGroupsForUserRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListInstanceProfilesResult listInstanceProfiles(ListInstanceProfilesRequest listInstanceProfilesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListInstanceProfilesResult listInstanceProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListInstanceProfilesForRoleResult listInstanceProfilesForRole(
			ListInstanceProfilesForRoleRequest listInstanceProfilesForRoleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListMFADevicesResult listMFADevices(ListMFADevicesRequest listMFADevicesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListMFADevicesResult listMFADevices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListOpenIDConnectProvidersResult listOpenIDConnectProviders(
			ListOpenIDConnectProvidersRequest listOpenIDConnectProvidersRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListOpenIDConnectProvidersResult listOpenIDConnectProviders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListPoliciesResult listPolicies(ListPoliciesRequest listPoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListPoliciesResult listPolicies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListPolicyVersionsResult listPolicyVersions(ListPolicyVersionsRequest listPolicyVersionsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListRolePoliciesResult listRolePolicies(ListRolePoliciesRequest listRolePoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListRolesResult listRoles(ListRolesRequest listRolesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListRolesResult listRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListSAMLProvidersResult listSAMLProviders(ListSAMLProvidersRequest listSAMLProvidersRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListSAMLProvidersResult listSAMLProviders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListSSHPublicKeysResult listSSHPublicKeys(ListSSHPublicKeysRequest listSSHPublicKeysRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListSSHPublicKeysResult listSSHPublicKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListServerCertificatesResult listServerCertificates(
			ListServerCertificatesRequest listServerCertificatesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListServerCertificatesResult listServerCertificates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListServiceSpecificCredentialsResult listServiceSpecificCredentials(
			ListServiceSpecificCredentialsRequest listServiceSpecificCredentialsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListSigningCertificatesResult listSigningCertificates(
			ListSigningCertificatesRequest listSigningCertificatesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListSigningCertificatesResult listSigningCertificates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListUserPoliciesResult listUserPolicies(ListUserPoliciesRequest listUserPoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListUsersResult listUsers(ListUsersRequest listUsersRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListUsersResult listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVirtualMFADevicesResult listVirtualMFADevices(
			ListVirtualMFADevicesRequest listVirtualMFADevicesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVirtualMFADevicesResult listVirtualMFADevices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PutGroupPolicyResult putGroupPolicy(PutGroupPolicyRequest putGroupPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PutRolePermissionsBoundaryResult putRolePermissionsBoundary(
			PutRolePermissionsBoundaryRequest putRolePermissionsBoundaryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PutRolePolicyResult putRolePolicy(PutRolePolicyRequest putRolePolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PutUserPermissionsBoundaryResult putUserPermissionsBoundary(
			PutUserPermissionsBoundaryRequest putUserPermissionsBoundaryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PutUserPolicyResult putUserPolicy(PutUserPolicyRequest putUserPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemoveClientIDFromOpenIDConnectProviderResult removeClientIDFromOpenIDConnectProvider(
			RemoveClientIDFromOpenIDConnectProviderRequest removeClientIDFromOpenIDConnectProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemoveRoleFromInstanceProfileResult removeRoleFromInstanceProfile(
			RemoveRoleFromInstanceProfileRequest removeRoleFromInstanceProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemoveUserFromGroupResult removeUserFromGroup(RemoveUserFromGroupRequest removeUserFromGroupRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResetServiceSpecificCredentialResult resetServiceSpecificCredential(
			ResetServiceSpecificCredentialRequest resetServiceSpecificCredentialRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResyncMFADeviceResult resyncMFADevice(ResyncMFADeviceRequest resyncMFADeviceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetDefaultPolicyVersionResult setDefaultPolicyVersion(
			SetDefaultPolicyVersionRequest setDefaultPolicyVersionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimulateCustomPolicyResult simulateCustomPolicy(SimulateCustomPolicyRequest simulateCustomPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimulatePrincipalPolicyResult simulatePrincipalPolicy(
			SimulatePrincipalPolicyRequest simulatePrincipalPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateAccessKeyResult updateAccessKey(UpdateAccessKeyRequest updateAccessKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateAccountPasswordPolicyResult updateAccountPasswordPolicy(
			UpdateAccountPasswordPolicyRequest updateAccountPasswordPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateAssumeRolePolicyResult updateAssumeRolePolicy(
			UpdateAssumeRolePolicyRequest updateAssumeRolePolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateGroupResult updateGroup(UpdateGroupRequest updateGroupRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateLoginProfileResult updateLoginProfile(UpdateLoginProfileRequest updateLoginProfileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateOpenIDConnectProviderThumbprintResult updateOpenIDConnectProviderThumbprint(
			UpdateOpenIDConnectProviderThumbprintRequest updateOpenIDConnectProviderThumbprintRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateRoleResult updateRole(UpdateRoleRequest updateRoleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateRoleDescriptionResult updateRoleDescription(
			UpdateRoleDescriptionRequest updateRoleDescriptionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateSAMLProviderResult updateSAMLProvider(UpdateSAMLProviderRequest updateSAMLProviderRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateSSHPublicKeyResult updateSSHPublicKey(UpdateSSHPublicKeyRequest updateSSHPublicKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateServerCertificateResult updateServerCertificate(
			UpdateServerCertificateRequest updateServerCertificateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateServiceSpecificCredentialResult updateServiceSpecificCredential(
			UpdateServiceSpecificCredentialRequest updateServiceSpecificCredentialRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateSigningCertificateResult updateSigningCertificate(
			UpdateSigningCertificateRequest updateSigningCertificateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateUserResult updateUser(UpdateUserRequest updateUserRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UploadSSHPublicKeyResult uploadSSHPublicKey(UploadSSHPublicKeyRequest uploadSSHPublicKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UploadServerCertificateResult uploadServerCertificate(
			UploadServerCertificateRequest uploadServerCertificateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UploadSigningCertificateResult uploadSigningCertificate(
			UploadSigningCertificateRequest uploadSigningCertificateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmazonIdentityManagementWaiters waiters() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
