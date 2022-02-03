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

3. Retrofit and db can be initialized in a different file and then can be provided from there,
since in bigger project we need different config of retrofit, that can be customised in the different file.
