package com.hohans.nsome.jungsan.repository.mongo.config;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public String getCurrentAuditor() {
		return "system";
	}

}
