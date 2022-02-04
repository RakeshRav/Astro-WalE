# Astro-WalE

Instructions:
1. Take pull of branch: RakeshRav-WalE
2. Due to security issues i am not pushing my API key, you can simply introduce field in gradle.properties
   "API_KEY" type "String" and provide your API key there. Since it is public repo it can be misused.
3. Sync project and run


Area of improvement
1. All the version of gradle dependency can be taken out to build.gradle(project level).
   so that it can be used with multimodular app with same version of each dependency across the different modules.

2. There are some hardcoded strings that can be taken to constants file

3. AstroBaseActivity can be used for many other common things to introduce, and that will help child
   classes get it and do their work directly, that will remove more boilerplate code.

4. there can be live data that can emit multiple values -> loading, success, failure. right now added cases for success and failure

5. Subtitle can be shorten to 3-4 lines, and we can give read more option to user

6. Hardcode colors can be taken to colors style

7. We can handle error with another cases when internet is not available, right now handled error as the last data we receive
from data layer is older and current date data is not available

8. isPrevDate can be used in try catch since there is chance of passing incorrect input

9. Test cases can be written for util classes, repositories, db classes. a sample test case is written for date util
