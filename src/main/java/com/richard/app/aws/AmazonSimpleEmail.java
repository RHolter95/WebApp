package com.richard.app.aws;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.services.simpleemail.waiters.AmazonSimpleEmailServiceWaiters;

@Service
public class AmazonSimpleEmail implements AmazonSimpleEmailService {

	@Override
	public void setEndpoint(String endpoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRegion(Region region) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CloneReceiptRuleSetResult cloneReceiptRuleSet(CloneReceiptRuleSetRequest cloneReceiptRuleSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateConfigurationSetResult createConfigurationSet(
			CreateConfigurationSetRequest createConfigurationSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateConfigurationSetEventDestinationResult createConfigurationSetEventDestination(
			CreateConfigurationSetEventDestinationRequest createConfigurationSetEventDestinationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateConfigurationSetTrackingOptionsResult createConfigurationSetTrackingOptions(
			CreateConfigurationSetTrackingOptionsRequest createConfigurationSetTrackingOptionsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateCustomVerificationEmailTemplateResult createCustomVerificationEmailTemplate(
			CreateCustomVerificationEmailTemplateRequest createCustomVerificationEmailTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateReceiptFilterResult createReceiptFilter(CreateReceiptFilterRequest createReceiptFilterRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateReceiptRuleResult createReceiptRule(CreateReceiptRuleRequest createReceiptRuleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateReceiptRuleSetResult createReceiptRuleSet(CreateReceiptRuleSetRequest createReceiptRuleSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateTemplateResult createTemplate(CreateTemplateRequest createTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteConfigurationSetResult deleteConfigurationSet(
			DeleteConfigurationSetRequest deleteConfigurationSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteConfigurationSetEventDestinationResult deleteConfigurationSetEventDestination(
			DeleteConfigurationSetEventDestinationRequest deleteConfigurationSetEventDestinationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteConfigurationSetTrackingOptionsResult deleteConfigurationSetTrackingOptions(
			DeleteConfigurationSetTrackingOptionsRequest deleteConfigurationSetTrackingOptionsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteCustomVerificationEmailTemplateResult deleteCustomVerificationEmailTemplate(
			DeleteCustomVerificationEmailTemplateRequest deleteCustomVerificationEmailTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteIdentityResult deleteIdentity(DeleteIdentityRequest deleteIdentityRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteIdentityPolicyResult deleteIdentityPolicy(DeleteIdentityPolicyRequest deleteIdentityPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteReceiptFilterResult deleteReceiptFilter(DeleteReceiptFilterRequest deleteReceiptFilterRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteReceiptRuleResult deleteReceiptRule(DeleteReceiptRuleRequest deleteReceiptRuleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteReceiptRuleSetResult deleteReceiptRuleSet(DeleteReceiptRuleSetRequest deleteReceiptRuleSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteTemplateResult deleteTemplate(DeleteTemplateRequest deleteTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteVerifiedEmailAddressResult deleteVerifiedEmailAddress(
			DeleteVerifiedEmailAddressRequest deleteVerifiedEmailAddressRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DescribeActiveReceiptRuleSetResult describeActiveReceiptRuleSet(
			DescribeActiveReceiptRuleSetRequest describeActiveReceiptRuleSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DescribeConfigurationSetResult describeConfigurationSet(
			DescribeConfigurationSetRequest describeConfigurationSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DescribeReceiptRuleResult describeReceiptRule(DescribeReceiptRuleRequest describeReceiptRuleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DescribeReceiptRuleSetResult describeReceiptRuleSet(
			DescribeReceiptRuleSetRequest describeReceiptRuleSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccountSendingEnabledResult getAccountSendingEnabled(
			GetAccountSendingEnabledRequest getAccountSendingEnabledRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetCustomVerificationEmailTemplateResult getCustomVerificationEmailTemplate(
			GetCustomVerificationEmailTemplateRequest getCustomVerificationEmailTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetIdentityDkimAttributesResult getIdentityDkimAttributes(
			GetIdentityDkimAttributesRequest getIdentityDkimAttributesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetIdentityMailFromDomainAttributesResult getIdentityMailFromDomainAttributes(
			GetIdentityMailFromDomainAttributesRequest getIdentityMailFromDomainAttributesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetIdentityNotificationAttributesResult getIdentityNotificationAttributes(
			GetIdentityNotificationAttributesRequest getIdentityNotificationAttributesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetIdentityPoliciesResult getIdentityPolicies(GetIdentityPoliciesRequest getIdentityPoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetIdentityVerificationAttributesResult getIdentityVerificationAttributes(
			GetIdentityVerificationAttributesRequest getIdentityVerificationAttributesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSendQuotaResult getSendQuota(GetSendQuotaRequest getSendQuotaRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSendQuotaResult getSendQuota() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSendStatisticsResult getSendStatistics(GetSendStatisticsRequest getSendStatisticsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSendStatisticsResult getSendStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetTemplateResult getTemplate(GetTemplateRequest getTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListConfigurationSetsResult listConfigurationSets(
			ListConfigurationSetsRequest listConfigurationSetsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListCustomVerificationEmailTemplatesResult listCustomVerificationEmailTemplates(
			ListCustomVerificationEmailTemplatesRequest listCustomVerificationEmailTemplatesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIdentitiesResult listIdentities(ListIdentitiesRequest listIdentitiesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIdentitiesResult listIdentities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIdentityPoliciesResult listIdentityPolicies(ListIdentityPoliciesRequest listIdentityPoliciesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListReceiptFiltersResult listReceiptFilters(ListReceiptFiltersRequest listReceiptFiltersRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListReceiptRuleSetsResult listReceiptRuleSets(ListReceiptRuleSetsRequest listReceiptRuleSetsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListTemplatesResult listTemplates(ListTemplatesRequest listTemplatesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVerifiedEmailAddressesResult listVerifiedEmailAddresses(
			ListVerifiedEmailAddressesRequest listVerifiedEmailAddressesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVerifiedEmailAddressesResult listVerifiedEmailAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PutIdentityPolicyResult putIdentityPolicy(PutIdentityPolicyRequest putIdentityPolicyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReorderReceiptRuleSetResult reorderReceiptRuleSet(
			ReorderReceiptRuleSetRequest reorderReceiptRuleSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendBounceResult sendBounce(SendBounceRequest sendBounceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendBulkTemplatedEmailResult sendBulkTemplatedEmail(
			SendBulkTemplatedEmailRequest sendBulkTemplatedEmailRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendCustomVerificationEmailResult sendCustomVerificationEmail(
			SendCustomVerificationEmailRequest sendCustomVerificationEmailRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendEmailResult sendEmail(SendEmailRequest sendEmailRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendRawEmailResult sendRawEmail(SendRawEmailRequest sendRawEmailRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendTemplatedEmailResult sendTemplatedEmail(SendTemplatedEmailRequest sendTemplatedEmailRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetActiveReceiptRuleSetResult setActiveReceiptRuleSet(
			SetActiveReceiptRuleSetRequest setActiveReceiptRuleSetRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetIdentityDkimEnabledResult setIdentityDkimEnabled(
			SetIdentityDkimEnabledRequest setIdentityDkimEnabledRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetIdentityFeedbackForwardingEnabledResult setIdentityFeedbackForwardingEnabled(
			SetIdentityFeedbackForwardingEnabledRequest setIdentityFeedbackForwardingEnabledRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetIdentityHeadersInNotificationsEnabledResult setIdentityHeadersInNotificationsEnabled(
			SetIdentityHeadersInNotificationsEnabledRequest setIdentityHeadersInNotificationsEnabledRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetIdentityMailFromDomainResult setIdentityMailFromDomain(
			SetIdentityMailFromDomainRequest setIdentityMailFromDomainRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetIdentityNotificationTopicResult setIdentityNotificationTopic(
			SetIdentityNotificationTopicRequest setIdentityNotificationTopicRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetReceiptRulePositionResult setReceiptRulePosition(
			SetReceiptRulePositionRequest setReceiptRulePositionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestRenderTemplateResult testRenderTemplate(TestRenderTemplateRequest testRenderTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateAccountSendingEnabledResult updateAccountSendingEnabled(
			UpdateAccountSendingEnabledRequest updateAccountSendingEnabledRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateConfigurationSetEventDestinationResult updateConfigurationSetEventDestination(
			UpdateConfigurationSetEventDestinationRequest updateConfigurationSetEventDestinationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateConfigurationSetReputationMetricsEnabledResult updateConfigurationSetReputationMetricsEnabled(
			UpdateConfigurationSetReputationMetricsEnabledRequest updateConfigurationSetReputationMetricsEnabledRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateConfigurationSetSendingEnabledResult updateConfigurationSetSendingEnabled(
			UpdateConfigurationSetSendingEnabledRequest updateConfigurationSetSendingEnabledRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateConfigurationSetTrackingOptionsResult updateConfigurationSetTrackingOptions(
			UpdateConfigurationSetTrackingOptionsRequest updateConfigurationSetTrackingOptionsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCustomVerificationEmailTemplateResult updateCustomVerificationEmailTemplate(
			UpdateCustomVerificationEmailTemplateRequest updateCustomVerificationEmailTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateReceiptRuleResult updateReceiptRule(UpdateReceiptRuleRequest updateReceiptRuleRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateTemplateResult updateTemplate(UpdateTemplateRequest updateTemplateRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerifyDomainDkimResult verifyDomainDkim(VerifyDomainDkimRequest verifyDomainDkimRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerifyDomainIdentityResult verifyDomainIdentity(VerifyDomainIdentityRequest verifyDomainIdentityRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerifyEmailAddressResult verifyEmailAddress(VerifyEmailAddressRequest verifyEmailAddressRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerifyEmailIdentityResult verifyEmailIdentity(VerifyEmailIdentityRequest verifyEmailIdentityRequest) {
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
	public AmazonSimpleEmailServiceWaiters waiters() {
		// TODO Auto-generated method stub
		return null;
	}

}
