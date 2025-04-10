package com.example.lokalassignment.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobsDTO (

    @SerialName("results" ) var results : ArrayList<Results> = arrayListOf()

)

@Serializable
data class PrimaryDetails (

    @SerialName("Place"         ) var Place         : String? = null,
    @SerialName("Salary"        ) var Salary        : String? = null,
    @SerialName("Job_Type"      ) var JobType       : String? = null,
    @SerialName("Experience"    ) var Experience    : String? = null,
    @SerialName("Fees_Charged"  ) var FeesCharged   : String? = null,
    @SerialName("Qualification" ) var Qualification : String? = null

)

@Serializable
data class FeeDetails (

    @SerialName("V3" ) var V3 : ArrayList<String> = arrayListOf()

)

@Serializable
data class JobTags (

    @SerialName("value"      ) var value     : String? = null,
    @SerialName("bg_color"   ) var bgColor   : String? = null,
    @SerialName("text_color" ) var textColor : String? = null

)

@Serializable
data class ContactPreference (

    @SerialName("preference"                ) var preference             : Int?    = null,
    @SerialName("whatsapp_link"             ) var whatsappLink           : String? = null,
    @SerialName("preferred_call_start_time" ) var preferredCallStartTime : String? = null,
    @SerialName("preferred_call_end_time"   ) var preferredCallEndTime   : String? = null

)

@Serializable
data class Creatives (

    @SerialName("file"          ) var file         : String? = null,
    @SerialName("thumb_url"     ) var thumbUrl     : String? = null,
    @SerialName("creative_type" ) var creativeType : Int?    = null

)

@Serializable
data class Locations (

    @SerialName("id"     ) var id     : Int?    = null,
    @SerialName("locale" ) var locale : String? = null,
    @SerialName("state"  ) var state  : Int?    = null

)

@Serializable
data class V3 (

    @SerialName("field_key"   ) var fieldKey   : String? = null,
    @SerialName("field_name"  ) var fieldName  : String? = null,
    @SerialName("field_value" ) var fieldValue : String? = null

)

@Serializable
data class ContentV3 (

    @SerialName("V3" ) var V3 : ArrayList<V3> = arrayListOf()

)


@Serializable
data class Results (

    @SerialName("id"                              ) var id                          : Int?                 = null,
    @SerialName("title"                           ) var title                       : String?              = null,
    @SerialName("type"                            ) var type                        : Int?                 = null,
    @SerialName("primary_details"                 ) var primaryDetails              : PrimaryDetails?      = PrimaryDetails(),
//    @SerialName("fee_details"                     ) var feeDetails                  : FeeDetails?          = FeeDetails(),
    @SerialName("job_tags"                        ) var jobTags                     : ArrayList<JobTags>   = arrayListOf(),
    @SerialName("job_type"                        ) var jobType                     : Int?                 = null,
    @SerialName("job_category_id"                 ) var jobCategoryId               : Int?                 = null,
    @SerialName("qualification"                   ) var qualification               : Int?                 = null,
    @SerialName("experience"                      ) var experience                  : Int?                 = null,
    @SerialName("shift_timing"                    ) var shiftTiming                 : Int?                 = null,
    @SerialName("job_role_id"                     ) var jobRoleId                   : Int?                 = null,
    @SerialName("salary_max"                      ) var salaryMax                   : Int?                 = null,
    @SerialName("salary_min"                      ) var salaryMin                   : Int?                 = null,
    @SerialName("city_location"                   ) var cityLocation                : Int?                 = null,
    @SerialName("locality"                        ) var locality                    : Int?                 = null,
    @SerialName("premium_till"                    ) var premiumTill                 : String?              = null,
    @SerialName("content"                         ) var content                     : String?              = null,
    @SerialName("company_name"                    ) var companyName                 : String?              = null,
    @SerialName("advertiser"                      ) var advertiser                  : Int?                 = null,
    @SerialName("button_text"                     ) var buttonText                  : String?              = null,
    @SerialName("custom_link"                     ) var customLink                  : String?              = null,
    @SerialName("amount"                          ) var amount                      : String?              = null,
    @SerialName("views"                           ) var views                       : Int?                 = null,
    @SerialName("shares"                          ) var shares                      : Int?                 = null,
    @SerialName("fb_shares"                       ) var fbShares                    : Int?                 = null,
    @SerialName("is_bookmarked"                   ) var isBookmarked                : Boolean?             = null,
    @SerialName("is_applied"                      ) var isApplied                   : Boolean?             = null,
    @SerialName("is_owner"                        ) var isOwner                     : Boolean?             = null,
    @SerialName("updated_on"                      ) var updatedOn                   : String?              = null,
    @SerialName("whatsapp_no"                     ) var whatsappNo                  : String?              = null,
    @SerialName("contact_preference"              ) var contactPreference           : ContactPreference?   = ContactPreference(),
    @SerialName("created_on"                      ) var createdOn                   : String?              = null,
    @SerialName("is_premium"                      ) var isPremium                   : Boolean?             = null,
    @SerialName("creatives"                       ) var creatives                   : ArrayList<Creatives> = arrayListOf(),
//    @SerialName("videos"                          ) var videos                      : ArrayList<String>    = arrayListOf(),
    @SerialName("locations"                       ) var locations                   : ArrayList<Locations> = arrayListOf(),
//    @SerialName("tags"                            ) var tags                        : ArrayList<String>    = arrayListOf(),
    @SerialName("contentV3"                       ) var contentV3                   : ContentV3?           = ContentV3(),
    @SerialName("status"                          ) var status                      : Int?                 = null,
    @SerialName("expire_on"                       ) var expireOn                    : String?              = null,
    @SerialName("job_hours"                       ) var jobHours                    : String?              = null,
    @SerialName("openings_count"                  ) var openingsCount               : Int?                 = null,
    @SerialName("job_role"                        ) var jobRole                     : String?              = null,
    @SerialName("other_details"                   ) var otherDetails                : String?              = null,
    @SerialName("job_category"                    ) var jobCategory                 : String?              = null,
    @SerialName("num_applications"                ) var numApplications             : Int?                 = null,
    @SerialName("enable_lead_collection"          ) var enableLeadCollection        : Boolean?             = null,
    @SerialName("is_job_seeker_profile_mandatory" ) var isJobSeekerProfileMandatory : Boolean?             = null,
//    @SerialName("translated_content"              ) var translatedContent           : TranslatedContent?   = TranslatedContent(),
    @SerialName("job_location_slug"               ) var jobLocationSlug             : String?              = null,
    @SerialName("fees_text"                       ) var feesText                    : String?              = null,
    @SerialName("question_bank_id"                ) var questionBankId              : String?              = null,
    @SerialName("screening_retry"                 ) var screeningRetry              : String?              = null,
    @SerialName("should_show_last_contacted"      ) var shouldShowLastContacted     : Boolean?             = null,
    @SerialName("fees_charged"                    ) var feesCharged                 : Int?                 = null

)