package com.almostsagar.handlebars.misc;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.ColumnOrderingStrategyLegacy;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class CustomColumnOrderingStrategy extends ColumnOrderingStrategyLegacy
        implements HibernatePropertiesCustomizer {
    @Override
    public List<Column> orderTableColumns(Table table, Metadata metadata) {
        return table.getColumns().stream()
                .toList();
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.COLUMN_ORDERING_STRATEGY, this);
    }
}
